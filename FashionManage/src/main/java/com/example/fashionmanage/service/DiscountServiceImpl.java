package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.repository.DiscountRepository;
import com.example.fashionmanage.validation.DiscountDto;
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
    private DiscountRepository discountRepository;

    @Override
    public Optional<Discount> findById(String id) {
        return discountRepository.findById(id);
    }

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
        return discountRepository.finAllDiscount();
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
        return discountRepository.findByIdDiscount(id);
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
        discountRepository.deleteByIdDiscount(id);
    }

    /**
     * The function help create new discount
     *
     * @param discountDto
     * @return author QuanNV
     */
    @Transactional
    @Override
    public void saveDiscount(DiscountDto discountDto) {
        Discount discount1 = modelMapper.map(discountDto, Discount.class);
        discountRepository.saveDiscount(discount1.getDiscountCode(), discount1.getName(), discount1.getRewardPoint(), discount1.getCondition(), discount1.getBeginDate(), discount1.getEndDate(), discount1.getCustomerType().getId());
    }

    /**
     * the function help update discount by id
     *
     * @param id
     * @param discount1
     * @return author QuanNV
     */
    @Override
    public Discount updateDiscount(String id, Discount discount1) {
        return discountRepository.updateDiscount(id, discount1);
    }

    @Override
    public List<Discount> findDiscount(Integer cusTypeId, Integer total, Date today) {
        return discountRepository.findDiscount(cusTypeId, total, today);
    }
}
