package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void update(String cid, Customer customer);
}
