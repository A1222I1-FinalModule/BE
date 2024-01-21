package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository  extends JpaRepository<CustomerType, Integer> {
}
