package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * The function help display all data of customer find by name
     *
     * @param name is code of customer
     * @return data of customer find by name
     * @author QuanNV
     */
    List<Customer> findByNameCustomer(String name);

    //QuanND
    void save(Customer customer);

    void update(String cid, Customer customer);

    boolean isPhoneUnique(String phone);
    boolean isEmailUnique(String phone);

    //BaoNV
    List<Customer> findAllByNameOrPhoneOrContainingId(String str);

    Optional<Customer> findById(String id);
    Customer findId(String cid);
}

