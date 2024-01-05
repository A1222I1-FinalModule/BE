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
    public List<Object[]> getTop5RecentOrder() {
        return billRepository.findTop5RecentOrders();
    }

    @Override
    public Object[] calculateCustomerGrowthPercentage() {
        return billRepository.calculateCustomerGrowthPercentage();
    }

    @Override
    public Object[] calculateOrderGrowthPercentage() {
        return billRepository.calculateOrderGrowthPercentage();
    }

    @Override
    public double calculateRevenueByWeek() {
        return billRepository.calculateRevenueByWeek();
    }

    @Override
    public double calculateRevenueByMonth() {
        return billRepository.calculateRevenueByMonth();
    }
}
