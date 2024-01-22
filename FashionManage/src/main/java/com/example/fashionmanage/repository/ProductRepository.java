package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAll();

    @Query(value = "select * from product where name LIKE %:name%", nativeQuery = true)
    List<Product> findByNameProduct(String name);


    @Query(value = "select * from product where product_category_id = :id", nativeQuery = true)
    List<Product> findByProductCategory(@Param("id") Integer id);
}


