package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Bill;
import com.example.fashionmanage.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillServiceImpl implements BIllService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Optional<Bill> findById(String id) {
        return billRepository.findById(id);
    }
}
