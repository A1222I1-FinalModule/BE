package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.repository.ProductRepository;
import com.example.fashionmanage.service.ProductService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    /**
     * this is method override by interface ProductService,is is used display all record in table product
     * @param :N/A
     * @author: TuyenDV
     * @return : if success , display all record in table product messager error
     */
    @Override
    public List<Product> findListInfoProduct() {
        return productRepository.findListInfoProduct();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


    /**
     * The function help display all data of product find by name
     *
     * @param name is code of product
     * @return data of product find by product
     * @author TuyenDV
     */
    @Override
    public List<Product> findByNameProduct(String name) {
        return productRepository.findByNameProduct(name);
    }

    /**
     * This is method overrride by interface ProductService,It is used to add  info product object
     * @param product
     * @author: TuyenDv
     * @Return : if success , object will insert not messager error
     */
//    @Transactional
    @Override
    public void createInfoProduct(Product product) {
        productRepository.createInfoProduct(product);
    }

}
