package com.example.fashionmanage.service.impl;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.ProductCategory;
import com.example.fashionmanage.repository.ProductCategoryRepository;
import com.example.fashionmanage.repository.ProductRepository;
import com.example.fashionmanage.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    /**
     * this is method override by interface ProductCategoryService,is is used display all record in table product_category
     * @param :N/A
     * @author: TuyenDV
     * @return : if success , display all record in table product_category messager error
     */
    @Override
    public List<ProductCategory> findlistCategory() {
        return productCategoryRepository.findListCategory();
    }



}
