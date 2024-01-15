package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.BillDetail;
import com.example.fashionmanage.repository.BillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillDetailServiceImpl implements BillDetailService {
    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public Optional<BillDetail> findById(String id) {
        return billDetailRepository.findById(id);
    }

    @Override
    public void save(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }
}
