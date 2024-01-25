package com.example.fashionmanage.service;

import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.GetBillDTO;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.entity.Bill;

import java.util.List;
import java.util.Optional;


public interface BIllService {
  List<Object[]> getAllBill();

  List<GetBillDTO> getTop5RecentOrder();

  List<CustomerGrowth> calculateCustomerGrowthPercentage();

  List<OrderGrowthDTO> calculateOrderGrowthPercentage();

  double calculateRevenueByDay();

  double calculateRevenueByWeek();

  double calculateRevenueByMonth();

  void save(Bill bill);

  Optional<Bill> findById(String id);
}
