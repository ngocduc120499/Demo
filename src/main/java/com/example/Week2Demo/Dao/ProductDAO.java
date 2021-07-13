package com.example.Week2Demo.Dao;

import com.example.Week2Demo.model.Products;

import java.util.List;

public interface ProductDAO {
    List<Products> findAll();
    void save(Products products);
    void update(Products products);
    void updateName(int id, String name);
    void deleteProduct(int id);
    Products findByID(int id);
}
