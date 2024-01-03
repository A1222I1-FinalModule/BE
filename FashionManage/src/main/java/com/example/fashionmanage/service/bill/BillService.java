package com.example.fashionmanage.service.bill;


import java.util.*;

import com.example.fashionmanage.entity.Bill;

public interface BillService {
  List<Bill> getAll();
  Bill getById(String id);
  Bill add(Bill bill);
  Bill update(String id, Bill bill);
  void deleteById(String id);
}
