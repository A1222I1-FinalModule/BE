package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerTypeRepository  extends JpaRepository<CustomerType, Integer> {
    @Query(value = "select * from customer_type", nativeQuery = true)
    List<CustomerType> findAll();
}
