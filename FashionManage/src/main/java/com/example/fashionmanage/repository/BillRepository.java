package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface BillRepository extends JpaRepository<Bill,String> {
    @Query(value = "SELECT * FROM bill ORDER BY release_date DESC LIMIT 5", nativeQuery = true)
    List<Bill> findTop5RecentOrders();
    @Query(value = "SELECT COUNT(DISTINCT customer_id) FROM bill", nativeQuery = true)
    double calculateCustomerGrowthPercentage();
    @Query(value = "")
    double calculateOrderGrowthPercentage();
    @Query(value = "")
    double calculateRevenueByWeek();
    @Query(value = "")
    double calculateRevenueByMonth();
}
