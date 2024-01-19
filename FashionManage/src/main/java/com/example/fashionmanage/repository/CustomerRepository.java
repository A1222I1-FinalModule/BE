package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> findAll();

    @Modifying
    @Transactional
    @Query(value = "insert into customer(id, name, date_of_birth, address, gender, phone, email, point, type_id) " +
            "values (:#{#customer.id}, :#{#customer.name}, :#{#customer.dateOfBirth},:#{#customer.address}, :#{#customer.gender},:#{#customer.phone}, :#{#customer.email}, :#{#customer.point}, :#{#customer.customerType.id}))", nativeQuery = true)
    void create(@Param("customer") Customer customer);

    @Query(value = "select id , name , gender,point,date_of_birth,address,phone,email,type_id from fashionShop.customer  " +
            "where id=:id",nativeQuery = true)
    Customer findByIdCustomer(String id);

    @Modifying
    @Transactional
    @Query(value = "update customer set name = :#{#customer.name}, date_of_birth = :#{#customer.dateOfBirth}, address = :#{#customer.address}, gender = :#{#customer.gender}, phone = :#{#customer.phone}, email = :#{#customer.email}, point = :#{#customer.point}, type_id = :#{#customer.customerType.id} " +
            "where id = :cid", nativeQuery = true)
    void update(@Param("cid") String cid, @Param("customer") Customer customer);
}
