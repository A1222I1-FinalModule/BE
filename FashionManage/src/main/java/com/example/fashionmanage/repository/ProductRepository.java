package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAll();


    @Query(value = "SELECT * FROM product "
            + "WHERE name LIKE %:name%", nativeQuery = true)
    Page<Product> findByProduct(@Param("name") String name,
                                Pageable pageable);

    @Query(value = "select * from product where product_category_id = :id", nativeQuery = true)
    List<Product> findByProductCategory(@Param("id") Integer id);
}


