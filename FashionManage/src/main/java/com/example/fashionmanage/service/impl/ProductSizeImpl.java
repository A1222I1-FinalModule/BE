package com.example.fashionmanage.service.impl;

import com.example.fashionmanage.entity.ProductSize;
import com.example.fashionmanage.repository.ProductSizeRepository;
import com.example.fashionmanage.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizeImpl implements ProductSizeService {
    @Autowired
    private ProductSizeRepository productSizeRepository;

    /**
     * this is method override by interface ProductSizeService,is is used display all record in table product_size
     * @param :N/A
     * @author: TuyenDV
     * @return : if success , display all record in table product_size messager error
     */
    @Override
    public List<ProductSize> findListProductSize() {
        return productSizeRepository.findListProductSize();
    }


    /**
     * this is method override by interface ProductService, it is used display record with id selected
     * @param id
     * @author :TuyenDV
     * @return : if it was id found record with selected is display not message error id not found
     */
    @Override
    public ProductSize findByIdProductSize(Integer id) {
        return productSizeRepository.findByIdListProductSize(id);
    }
}
