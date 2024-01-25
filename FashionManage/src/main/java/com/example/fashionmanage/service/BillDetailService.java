package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.BillDetail;

import java.util.Optional;

public interface BillDetailService {
    Optional<BillDetail> findById(Integer id);
    void save(BillDetail billDetail);
}
