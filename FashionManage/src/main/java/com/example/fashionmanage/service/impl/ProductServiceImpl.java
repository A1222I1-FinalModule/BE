package com.example.fashionmanage.service.impl;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.repository.ProductRepository;
import com.example.fashionmanage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByNameProduct(String name) {
        return repository.findByNameProduct(name);
    }
}
