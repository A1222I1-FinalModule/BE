package com.example.fashionmanage.service;

import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.GetBillDTO;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.entity.Bill;

import java.util.List;
import java.util.Optional;

public interface BillService {
    List<GetBillDTO> getTop5RecentOrder();
    List<CustomerGrowth> calculateCustomerGrowthPercentage();
    List<OrderGrowthDTO> calculateOrderGrowthPercentage();
    double calculateRevenueByWeek();

    double calculateRevenueByMonth();
    double calculateRevenueByDay();
    void save(Bill bill);
    List<Object[]> getAllBill();
    Optional<Bill> findById(String id);
}