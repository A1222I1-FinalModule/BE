package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Bill;

import java.util.Optional;

public interface BIllService {
    void save(Bill bill);

    Optional<Bill> findById(String id);
}
