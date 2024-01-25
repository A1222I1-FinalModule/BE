package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     *  This is the createInfoProduct(Product product) method, which is created for reuse by subclasses,Its purpose is to add data
     * @param product
     * @author :TuyenDV
     * @Return : if this method success, data will insert in table product , unless data isn't insert table and message error
     */
    void createInfoProduct(Product product);


    /**
     * This is the findListInfoProduct(), which is created for reuse by subclasses, Its purpose is to display the product list
     * @param :N/A
     * @author : TuyenDV
     * @Return : display list product
     */
    List<Product> findListInfoProduct();


    /**
     * This is findByNameProduct(), created to be reused by subclasses, Its purpose is to find the product name
     * @param :N/A
     * @author : TuyenDV
     * @Return :  show list product name searched
     */
    List<Product> findByNameProduct(String name);

    List<Product> findAll();
    Optional<Product> findById(String id);
    void save(Product product);


    /**
     * This is findByNameProduct(), created to be reused by subclasses, Its purpose is to find the product productCode
     * @param :N/A
     * @author : TuyenDV
     * @Return : show list product productCode searched
     */
    List<Product> findByProductCode(String productCode);
}
