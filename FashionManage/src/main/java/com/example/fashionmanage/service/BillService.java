package com.example.fashionmanage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.GetBillDTO;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.entity.Bill;

@Service
public interface BillService {
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
