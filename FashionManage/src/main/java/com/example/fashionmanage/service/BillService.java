package com.example.fashionmanage.service;

import com.example.fashionmanage.dto.BillDTO;
import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.entity.Bill;

import java.util.List;

public interface BillService {
    List<Object[]> getAllBill();

    List<BillDTO> getTop5RecentOrder();

    List<CustomerGrowth> calculateCustomerGrowthPercentage();

    List<OrderGrowthDTO> calculateOrderGrowthPercentage();

    double calculateRevenueByDay();

    double calculateRevenueByWeek();

    double calculateRevenueByMonth();
}
