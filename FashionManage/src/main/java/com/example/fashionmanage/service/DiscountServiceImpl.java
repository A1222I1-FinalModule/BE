package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.repository.DiscountRepository;
import com.example.fashionmanage.dto.DiscountDto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepository discount;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * The function help display all data of list discount
     *
     * @return list data of discount
     * @author QuanNV
     */
    @Override
    public List<Discount> findAllDiscount() {
        return discount.finAllDiscount();
    }

    /**
     * The function help display all data of discount find by id
     *
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @Override
    public Discount findByIdDiscount(String id) {
        return discount.findByIdDiscount(id);
    }

    /**
     * The function help delete all data of discount find by id
     *
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    @Override
    public void deleteByIdDiscount(String id) {
        discount.isDelete(id);
    }

    /**
     * The function help create new discount
     *
     * @param discountDto
     * @return author QuanNV
     */
    @Transactional
    @Override
    public void createDiscount(DiscountDto discountDto) {
        Discount discount1 = modelMapper.map(discountDto, Discount.class);
        discount.createDiscount(discount1);
    }

    /**
     * the function help update discount by id
     * @param id
     * @param discountDto
     * @return
     */
    @Transactional
    @Override
    public int updateDiscount(String id,DiscountDto discountDto) {
        Discount discount1 = modelMapper.map(discountDto, Discount.class);
        return discount.updateDiscount(id,discount1);
    }

    /**
     * The function help display all data of discount find by name
     *
     * @param name is code of discount
     * @return data of discount find by dicount
     * @author QuanNV
     */
    @Override
    public List<Discount> findByNameDiscountBothCustomerType(String name, Integer customerType) {
        return discount.findByNameDiscountBothCustomerType(name,customerType);
    }

    /**
     * The function help display all data of discount find by name
     *
     * @param customerType is code of discount
     * @return data of discount find by dicount
     * @author QuanNV
     */
    @Override
    public List<Discount> findByDiscountCustomerType(Integer customerType) {
        return discount.findByDiscountCustomerType(customerType);
    }

    @Override
    public List<Discount> findByNameDiscount(String name) {
        return discount.findByNameDiscount(name);
    }

    /**
     * The function help allows to know if the id already exists
     * @param id
     * @return true or false
     */
    @Override
    public boolean checkIdDiscount(String id) {
        return discount.countByDiscountCode(id) > 0;
    }

    @Override
    public List<String> listDiscountCode() {
        return discount.listDiscountCode();
    }

    @Override
    public Optional<Discount> findById(String id) {
        return discount.findById(id);
    }

    /**
     * The function findDiscount
     * @param cusTypeId
     * @param today
     * @author BaoDV
     */
    @Override
    public List<Discount> findDiscount(Integer cusTypeId, Integer total, Date today) {
        return discount.findDiscount(cusTypeId, total, today);
    }

}
