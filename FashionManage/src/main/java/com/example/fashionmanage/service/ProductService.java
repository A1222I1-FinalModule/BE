package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import java.util.List;

public interface ProductService {

    /**
     * The function help create new product
     * @param product
     * @return
     * author TuyenDV
     */
    void createInfoProduct(Product product);


    /**
     * The function help display all data of list product
     * @author TuyenDV
     * @return list data of product
     */
    List<Product> findListInfoProduct();



}
