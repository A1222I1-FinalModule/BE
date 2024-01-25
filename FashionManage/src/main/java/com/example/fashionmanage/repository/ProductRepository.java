package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAll();
}


