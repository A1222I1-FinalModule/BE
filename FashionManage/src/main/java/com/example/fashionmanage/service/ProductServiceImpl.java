package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    /**
     * The function help display all data of list product
     * @author TuyenDV
     * @return list data of product
     */
    @Override
    public List<Product> findListInfoProduct() {
        return productRepository.findListInfoProduct();
    }

    /**
     * The function help create new product
     * @param product
     * @return
     * author TuyenDV
     */
    @Transactional
    @Override
    public void createInfoProduct(Product product) {
        productRepository.createInfoProduct(product);
    }


}
