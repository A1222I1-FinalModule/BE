package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllInfoProduct() {
        return productRepository.findInfoProduct();
    }


    @Transactional
    @Override
    public void createInfoProduct(Product product) {
        productRepository.createInfoProduct(product);
    }


}
