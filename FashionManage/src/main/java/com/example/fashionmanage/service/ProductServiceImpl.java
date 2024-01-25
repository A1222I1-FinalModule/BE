package com.example.fashionmanage.service;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Product> findByProduct(String name, Pageable pageable) {
        return productRepository.findByProduct(name, pageable);
    }

    @Override
    public List<Product> findByProductCategories(Integer id) {
        return productRepository.findByProductCategory(id);
    }
    public void updateProductQuantity(Product product) {
        Optional<Product> fromDB = productRepository.findById(product.getProductCode());
        if (!fromDB.isPresent()) {
            throw new NullPointerException("Product is null");
        } else {
            product.setQuantity(fromDB.get().getQuantity() + product.getQuantity());
            productRepository.save(product);
        }
    }
}
