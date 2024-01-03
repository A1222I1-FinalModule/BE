package com.example.fashionmanage.repository.bill;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fashionmanage.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, String> {
  
}
