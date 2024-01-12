package com.example.fashionmanage.service.impl;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.repository.CustomerRepository;
import com.example.fashionmanage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Customer customer) {
        repository.create(customer);
    }

    @Override
    public void update(String cid, Customer customer) {
        Customer newCustomer = repository.findById(cid).orElse(null);
        if (newCustomer != null) {
            repository.update(cid, customer);
        }
    }
}
