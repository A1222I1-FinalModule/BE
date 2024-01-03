package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT c.* FROM Customer c WHERE c.phone LIKE %:searchStr% OR c.name LIKE %:searchStr% OR c.id = :searchStr", nativeQuery = true)
    List<Customer> findAllByNameOrPhoneOrContainingId(@Param("searchStr") String searchStr);
}
