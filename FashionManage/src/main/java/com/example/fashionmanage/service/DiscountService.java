package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Discount;

import java.util.Optional;

public interface DiscountService {
    Optional<Discount> findById(String id);
}
