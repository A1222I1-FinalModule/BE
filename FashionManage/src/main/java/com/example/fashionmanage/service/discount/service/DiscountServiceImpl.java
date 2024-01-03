package com.example.fashionmanage.service.discount.service;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.repository.discount.DiscountRepository;
import com.example.fashionmanage.dto.DiscountDto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements com.example.fashionmanage.service.discount.inter.DiscountService {
    @Autowired
    private DiscountRepository discount;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * The function help display all data of list discount
     * @author QuanNV
     * @return list data of discount
     */
    @Override
    public List<Discount> findAllDiscount() {
        return discount.finAllDiscount();
    }

    /**
     * The function help display all data of discount find by id
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
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    @Override
    public void deleteByIdDiscount(String id) {
        discount.deleteByIdDiscount(id);
    }

    /**
     * The function help create new discount
     * @param discountDto
     * @return
     * author QuanNV
     */
    @Transactional
    @Override
    public void saveDiscount(DiscountDto discountDto) {
        Discount discount1=modelMapper.map(discountDto, Discount.class);
        discount.saveDiscount(discount1.getDiscountCode(),discount1.getName(),discount1.getRewardPoint(),discount1.getCondition(),discount1.getBeginDate(),discount1.getEndDate(),discount1.getCustomerType().getId());
    }

    /**
     * the function help update discount by id
     * @param id
     * @param discount1
     * @return
     * author QuanNV
     */
    @Override
    public Discount updateDiscount(String id, Discount discount1) {
        return discount.updateDiscount(id,discount1);
    }
}
