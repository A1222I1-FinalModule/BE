package com.example.fashionmanage.service.discount.inter;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.validation.DiscountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountServiceInter {
    /**
     * The function help display all data of list discount
     * @author QuanNV
     * @return list data of discount
     */
    List<Discount> findAllDiscount();

    /**
     * The function help display all data of discount find by id
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    Discount findByIdDiscount(String id);

    /**
     * The function help delete all data of discount find by id
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    void deleteByIdDiscount(String id);

    /**
     * The function help create new discount
     * @param discount
     * @return
     * author QuanNV
     */
    void saveDiscount(DiscountDto discount);

    /**
     * the function help update discount by id
     * @param id
     * @param discount
     * @return
     * author QuanNV
     */
    Discount updateDiscount(String id, Discount discount);
}
