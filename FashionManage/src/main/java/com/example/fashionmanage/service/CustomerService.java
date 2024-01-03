package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAllByNameOrPhoneOrContainingId(String str);

    Optional<Customer> findById(String id);

    void save(Customer customer);
}
