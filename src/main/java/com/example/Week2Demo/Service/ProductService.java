package com.example.Week2Demo.Service;

import com.example.Week2Demo.Dao.ProductDAO;
import com.example.Week2Demo.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductService(@Qualifier("productDAO") ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    public List<Products> findAll(){
         return productDAO.findAll();
    }
    public void save(Products products){
        productDAO.save(products);
    }
    public void update(Products products){
        productDAO.update(products);
    }
    public void updateName(int id, String name){
        productDAO.updateName(id, name);
    }
    public void deleteProduct(int id){
        productDAO.deleteProduct(id);
    }
    public Products findByID(int id){
        return productDAO.findByID(id);
    }

}
