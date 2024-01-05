package com.example.fashionmanage.service.discount.inter;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.dto.DiscountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
//    void saveDiscount(DiscountDto discount);
    void createDiscount(DiscountDto discountDto);
    /**
     * the function help update discount by id
     *
     * @param discount
     * @return author QuanNV
     */
    int updateDiscount(DiscountDto discount);
}
