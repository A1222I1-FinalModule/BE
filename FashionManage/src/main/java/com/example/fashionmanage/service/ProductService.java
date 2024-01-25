package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Page<Product> findByProduct(String name, Pageable pageable);

    List<Product> findByProductCategories(Integer id);

    Optional<Product> findById(String id);

    void save(Product product);
}
