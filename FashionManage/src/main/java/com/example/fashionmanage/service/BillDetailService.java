package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.BillDetail;

import java.util.Optional;

public interface BillDetailService {
    Optional<BillDetail> findById(String id);
    void save(BillDetail billDetail);
}
