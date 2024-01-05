package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/warehouse")
public class ProductController {
    @Autowired
    private ProductService productService;

   @GetMapping("/getListProduct")
   public ResponseEntity<List<Product>> getAllInfoProduct(){
       try{
           List<Product> products = productService.findAllInfoProduct();
           if(products.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }else {
               return new ResponseEntity<>(products,HttpStatus.OK);
           }
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
   }

    /**
     * The function help create new product
     * @param product
     * @return
     * author TuyenNV
     */
    @PostMapping("/createInfoProduct")
    public ResponseEntity<?> saveInfoProduct(@Valid @RequestBody Product product){
        try {
            productService.createInfoProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
