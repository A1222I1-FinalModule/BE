package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryService {
    /**
     * This is the findlistCategory(), which is created for reuse by subclasses, Its purpose is to display the productCategory list
     * @param :N/A
     * @author : TuyenDV
     * @Return : display list productCategory
     */
    List<ProductCategory> findlistCategory();
}
