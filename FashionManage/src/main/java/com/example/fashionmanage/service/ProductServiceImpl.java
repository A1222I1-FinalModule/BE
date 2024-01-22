package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByNameProduct(String name) {
        return productRepository.findByNameProduct(name);
    }

    @Override
    public List<Product> findByProductCategories(Integer id) {
        return productRepository.findByProductCategory(id);
    }
}
