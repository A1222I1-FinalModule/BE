package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Bill;

import java.util.List;

public interface BillService {
    List<Object[]> getTop5RecentOrder();
    Object[] calculateCustomerGrowthPercentage();
    Object[] calculateOrderGrowthPercentage();
    double calculateRevenueByWeek();
    double calculateRevenueByMonth();
}
