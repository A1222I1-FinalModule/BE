package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.finAllCustomer();
    }

    @Override
    public void deleteByIdCustomer(String id) {
        customerRepository.deleteByIdCustomer(id);
    }

    @Override
    public Customer findByIdCustomer(String id) {
        return customerRepository.findByIdCustomer(id);
    }

    @Override
    public List<Customer> findByNameCustomer(String name) {
        return customerRepository.findByNameCustomer(name);
    }
}
