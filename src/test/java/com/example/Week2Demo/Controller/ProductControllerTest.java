package com.example.Week2Demo.Controller;

import com.example.Week2Demo.Dao.ProductDAO;
import com.example.Week2Demo.Repository.ProductRepository;
import com.example.Week2Demo.Service.ProductService;
import com.example.Week2Demo.Week2DemoApplicationTests;
import com.example.Week2Demo.model.Products;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.exception.DataException;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MimeTypeUtils;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ProductControllerTest extends Week2DemoApplicationTests{
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private ProductDAO productDAO;

    DemoCalculator underTest = new DemoCalculator();
    @Test
    public void testListProduct() throws  Exception{
        //given
        List<Products> listProducts = new ArrayList<>();
        listProducts.add(new Products(1,"duc","hello"));

        Mockito.when(productService.findAll()).thenReturn(listProducts);
        //when
        String url = "/product";
      MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
      String actualJsonResponse = mvcResult.getResponse().getContentAsString();
      System.out.println(actualJsonResponse);
      String expected = objectMapper.writeValueAsString(listProducts);
        System.out.println(expected);
      //then
      assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expected);

    }
    @Test
    public void testSaveProduct() throws Exception {
        Products newProduct = new Products("Product1","This is product");
        Products savedProducts = new Products(1,"Product1","This is product");
        String url = "/product";
        Mockito.when(productRepository.save(newProduct)).thenReturn(savedProducts);
        mockMvc.perform(post(url).contentType("application/json")
                .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isOk());

    }
    @Test
    public void testDeleteProduct() throws Exception{
        Integer productId = 1;
        Mockito.doNothing().when(productService).deleteProduct(productId);
        String url = "/product/"+productId;
        mockMvc.perform(delete(url)).andExpect(status().isOk());
        Mockito.verify(productService,times(1)).deleteProduct(productId);
    }
    @Test
    public void testProductNameMustNotBeBlank() throws JsonProcessingException,Exception{
        Products pr = new Products("","dada");
        String url = "/product";
        mockMvc.perform(post(url)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pr))).andExpect(status().isBadRequest());
        Mockito.verify(productService,times(0)).save(pr);
    }
    @Test
    void addNumberTest(){
        int a = 30;
        int b = 30;
        int result = underTest.add(a,b);
        assertThat(result).isEqualTo(40);

    }
    class DemoCalculator{
        int add(int a, int b){
            return a+b;
        }
    }



}