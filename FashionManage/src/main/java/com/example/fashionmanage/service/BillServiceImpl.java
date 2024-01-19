package com.example.fashionmanage.service;

import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.GetBillDTO;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.entity.Bill;
import com.example.fashionmanage.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

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

    @Override
    public List<GetBillDTO> getTop5RecentOrder() {
        return billRepository.findTop5RecentOrders();
    }

    @Override
    public List<CustomerGrowth> calculateCustomerGrowthPercentage() {
        return billRepository.calculateCustomerGrowthPercentage();
    }

    @Override
    public List<OrderGrowthDTO> calculateOrderGrowthPercentage() {
        return billRepository.calculateOrderGrowthPercentage();
    }

    @Override
    public double calculateRevenueByDay() {
        return billRepository.calculateRevenueByDay();
    }
    @Override
    public double calculateRevenueByWeek() {
        return billRepository.calculateRevenueByWeek();
    }

    @Override
    public double calculateRevenueByMonth() {
        return billRepository.calculateRevenueByMonth();
    }

    @Override
    public List<Object[]> getAllBill() {
        return billRepository.findBillsInMonth();
    }

}
