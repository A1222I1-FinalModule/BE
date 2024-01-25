package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
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
    //BaoNV
    @Override
    public List<Customer> findAllByNameOrPhoneOrContainingId(String str) {
        return customerRepository.findAllByNameOrPhoneOrContainingId(str);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer findId(String cid) {
        return customerRepository.findByIdCustomer(cid);
    }

    //QuanND

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(String cid, Customer customer) {
        Customer newCustomer = customerRepository.findById(cid).orElse(null);
        if (newCustomer != null) {
            customerRepository.update(cid, customer);
        }
    }
}
