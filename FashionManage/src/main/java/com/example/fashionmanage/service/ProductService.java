package com.example.fashionmanage.service;
import com.example.fashionmanage.entity.Product;
import java.util.List;

public interface ProductService {
    void createInfoProduct(Product product);
    List<Product> findAllInfoProduct();
}
