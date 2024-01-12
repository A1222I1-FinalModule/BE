package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list-product")
    public ResponseEntity<?> findAllDiscount(){
        List<Product> discounts=productService.findAll();
        if(discounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(discounts);

    }
}
