package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    void updateQuantity(Integer quantity, Product product);
    Optional<Product> findById(String id);
    void save(Product product);
}