package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list-product")
    public ResponseEntity<?> findAllDiscount(){
        List<Product> products = productService.findAll();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(products);
    }

    @GetMapping("/findByNameProduct")
    public ResponseEntity<?> findByNameProduct (@RequestParam(value = "name" ,required = false) String name ){
        List<Product> products = productService.findByNameProduct(name);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
