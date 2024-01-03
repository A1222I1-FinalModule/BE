package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Bill;

import java.util.List;
import java.util.Optional;

public interface BillService {
    List<Bill> getTop5RecentOrder();

    double calculateCustomerGrowthPercentage();

    double calculateOrderGrowthPercentage();

    double calculateRevenueByWeek();

    double calculateRevenueByMonth();

    void save(Bill bill);

    Optional<Bill> findById(String id);
}
