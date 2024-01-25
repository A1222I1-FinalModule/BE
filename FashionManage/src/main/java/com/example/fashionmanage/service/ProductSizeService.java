package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.ProductSize;

import java.util.List;

public interface ProductSizeService {

    /**
     * This is the findListProductSize(), which is created for reuse by subclasses, Its purpose is to display the productSize list
     * @param :N/A
     * @author : TuyenDV
     * @Return : display list productSize
     */
    List<ProductSize> findListProductSize();

    /**
     * this is findByIdProductSize, which is created for reuse by subclasses, Its purpose is to return the object with the corresponding ID
     * @param id
     * @author: TuyenDV
     * @return : display object with id selected
     */
     ProductSize findByIdProductSize(Integer id);

}
