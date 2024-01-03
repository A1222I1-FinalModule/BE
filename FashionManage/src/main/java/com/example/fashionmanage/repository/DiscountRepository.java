package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, String> {
}
