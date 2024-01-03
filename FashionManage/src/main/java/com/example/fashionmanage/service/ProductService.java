package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(String id);
    void save(Product product);
}
