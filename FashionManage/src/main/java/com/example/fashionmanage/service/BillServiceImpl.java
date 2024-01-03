package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Bill;
import com.example.fashionmanage.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<Bill> getTop5RecentOrder() {
        return billRepository.findTop5RecentOrders();
    }

    @Override
    public double calculateCustomerGrowthPercentage() {
        return 0;
    }

    @Override
    public double calculateOrderGrowthPercentage() {
        return 0;
    }

    @Override
    public double calculateRevenueByWeek() {
        return 0;
    }

    @Override
    public double calculateRevenueByMonth() {
        return 0;
    }

}
