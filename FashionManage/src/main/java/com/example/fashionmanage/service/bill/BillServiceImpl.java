package com.example.fashionmanage.service.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashionmanage.entity.Bill;
import com.example.fashionmanage.repository.bill.BillRepository;

@Service
public class BillServiceImpl implements BillService {
  @Autowired
  private BillRepository repository;

  @Override
  public List<Bill> getAll() {
    return repository.findAll();
  }

  @Override
  public Bill getById(String id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Bill add(Bill bill) {
    if (bill.getCustomer() == null) {
      return null;
    }
    if (bill.getReleaseDate() == null) {
      return null;
    }
    return repository.save(bill);
  }

  @Override
  public Bill update(String id, Bill bill) {
    Bill fromDB = repository.findById(id).orElse(null);
    if (fromDB == null)
      return null;
    fromDB.setTotal(bill.getTotal());
    fromDB.setReleaseDate(bill.getReleaseDate());
    fromDB.setBillDetails(bill.getBillDetails());
    fromDB.setCustomer(bill.getCustomer());
    return repository.save(fromDB);
  }

  @Override
  public void deleteById(String id) {
    repository.deleteById(id);
  }
}
