package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.dto.DiscountDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DiscountService {
    /**
     * The function help display all data of list discount
     *
     * @return list data of discount
     * @author QuanNV
     */
    List<Discount> findAllDiscount();

    /**
     * The function help display all data of discount find by id
     *
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    Discount findByIdDiscount(String id);

    /**
     * The function help delete all data of discount find by id
     *
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    void deleteByIdDiscount(String id);

    /**
     * The function help create new discount
     *
     * @param discountDto
     * @return author QuanNV
     */
    void createDiscount(DiscountDto discountDto,int number);

    /**
     * the function help update discount by id
     * @param id
     * @param discount
     * @return author QuanNV
     */
    int updateDiscount(String id,DiscountDto discount);

    /**
     * The function help display all data of discount find by name
     *
     * @param name is code of discount
     * @return data of discount find by name
     * @author QuanNV
     */
    List<Discount> findByNameDiscount(String name);

    /**
     * The function help display all data of discount find by name
     *
     * @param name is code of discount
     * @param customerType of customer type
     * @return data of discount find by name
     * @author QuanNV
     */
    List<Discount> findByNameDiscountBothCustomerType(String name,Integer customerType);

    /**
     * The function help display all data of discount find by customerType
     *
     * @param customerType of customer type
     * @return data of discount find by name
     * @author QuanNV
     */
    List<Discount> findByDiscountCustomerType(Integer customerType);

    /**
     * The function help allows to know if the id already exists
     * @param id
     * @author QuanNV
     */
    boolean checkIdDiscount(String id);

    /**
<<<<<<< HEAD
     * The function help display all data discountCode
     *
     * @return list data of discountCode
     * @author QuanNV
     */
    List<String>listDiscountCode();

    /**
     * The function findDiscount
     * @param cusTypeId
     * @param today
     * @author BaoDV
     */
    List<Discount> findDiscount(Integer cusTypeId, Integer total, Date today);
    Optional<Discount> findById(String id);

    int maxNumber();
}
