package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.entity.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    /**
     * The function help display all data of list customer
     *
     * @return list data of customer
     * @author QuanNV
     */
    List<Customer> findAllCustomer();

    /**
     * The function help delete all data of customer find by id
     *
     * @param id is code of customer
     * @return
     * @author QuanNV
     */
    void deleteByIdCustomer(String id);

    /**
     * The function help display all data of customer find by id
     *
     * @param id is code of customer
     * @return data of customer find by id
     * @author QuanNV
     */
    Customer findByIdCustomer(String id);

}
