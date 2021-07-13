package com.example.Week2Demo.Repository;

import com.example.Week2Demo.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
