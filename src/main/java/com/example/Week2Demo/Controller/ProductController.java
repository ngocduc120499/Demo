package com.example.Week2Demo.Controller;

import com.example.Week2Demo.Service.ProductService;
import com.example.Week2Demo.model.Customer;
import com.example.Week2Demo.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product" )
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Products>> findAll(){

        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<Products> findByID(@PathVariable int id){
        return ResponseEntity.ok(productService.findByID(id));
    }
    @PostMapping
    public void save(@Valid @RequestBody Products products){
        productService.save(products);
        System.out.println("Hello");
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id){

        productService.deleteProduct(id);
    }
    @PutMapping(path = "{id}")
    public void put(@PathVariable int id, @RequestBody Products products){
        products.setId(id);
        productService.update(products);
    }

    @PutMapping( path = "update/{id}")
    public void putName(@PathVariable int id, @RequestBody Products products){
        products.setId(id);
        productService.updateName(products.getId(), products.getName());
    }


}
