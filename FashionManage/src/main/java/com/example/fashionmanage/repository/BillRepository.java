package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, String> {
}
