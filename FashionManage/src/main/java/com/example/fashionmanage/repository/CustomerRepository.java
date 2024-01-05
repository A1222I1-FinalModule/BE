package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    /**
     * the function help search customer based on a string
     *
     * @param searchStr
     * @return list Customer
     * @author BaoDV
     */
    @Query(value = "SELECT c.* FROM customer c WHERE c.phone LIKE %:searchStr% OR c.name LIKE %:searchStr% OR c.id = :searchStr", nativeQuery = true)
    List<Customer> findAllByNameOrPhoneOrContainingId(@Param("searchStr") String searchStr);
}