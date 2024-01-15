package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Customer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
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

    /**
     * The function help display all data of customer find by name
     *
     * @param name is code of customer
     * @return data of customer find by name
     * @author QuanNV
     */
    @Query(value = "select id , name , gender,point,date_of_birth,address,phone,email,type_id from fashionShop.customer  " +
            "where name LIKE %:name%",nativeQuery = true)
    List<Customer> findByNameCustomer(String name);

    /**
     * the function help search customer based on a string
     *
     * @param searchStr
     * @return list Customer
     * @author BaoDV
     */
    @Query(value = "SELECT c.* FROM customer c WHERE c.phone LIKE %:searchStr% OR c.name LIKE %:searchStr% OR c.id = :searchStr", nativeQuery = true)
    List<Customer> findAllByNameOrPhoneOrContainingId(@Param("searchStr") String searchStr);

    //QuanND
    @Modifying
    @Transactional
    @Query(value = "insert into customer(id, name, date_of_birth,address, gender, phone, email, type_id) " +
            "values (:#{#customer.id}, :#{#customer.name}, :#{#customer.dateOfBirth},:#{#customer.address}, :#{#customer.gender},:#{#customer.phone}, :#{#customer.email}, :#{#customer.customerType.id})", nativeQuery = true)
    void create(@Param("customer") Customer customer);

    @Modifying
    @Transactional
    @Query(value = "update customer set name = :#{#customer.name}, date_of_birth = :#{#customer.dateOfBirth}, address = :#{#customer.address}, gender = :#{#customer.gender}, phone = :#{#customer.phone}, email = :#{#customer.email}, type_id = :#{#customer.customerType.id} " +
            "where id = :cid", nativeQuery = true)
    void update(@Param("cid") String cid, @Param("customer") Customer customer);
}