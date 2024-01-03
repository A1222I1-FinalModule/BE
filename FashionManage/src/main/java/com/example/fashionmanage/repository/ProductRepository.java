package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
