package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getTop5RecentOrder();
    double calculateCustomerGrowthPercentage();
    double calculateOrderGrowthPercentage();
    double calculateRevenueByWeek();
    double calculateRevenueByMonth(Integer month);
}
