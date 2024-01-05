package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.entity.Discount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    /**
     * The function help display all data of list discount
     *
     * @return list data of discount
     * @author QuanNV
     */
    @Query(value = "select id , name , gender,point,date_of_birth,address,phone,email,type_id " +
            "from fashionShop.customer ", nativeQuery = true)
    List<Customer> finAllCustomer();

    /**
     * The function help delete all data of customer find by id
     *
     * @param id is code of customer
     * @return
     * @author QuanNV
     */
    @Modifying
    @Transactional
    @Query(value = "delete from fashionShop.customer  where id=:id", nativeQuery = true)
    void deleteByIdCustomer(@Param("id") String id);

    /**
     * The function help display all data of customer find by id
     *
     * @param id is code of customer
     * @return data of customer find by id
     * @author QuanNV
     */
    @Query(value = "select id , name , gender,point,date_of_birth,address,phone,email,type_id from fashionShop.customer  " +
            "where id=:id",nativeQuery = true)
    Customer findByIdCustomer(String id);
}
