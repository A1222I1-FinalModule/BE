package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.ProductCategory;
import com.example.fashionmanage.service.ProductCategoryService;
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
@RequestMapping("/api/warehouse")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;
    /**
     * The function help list productCategory
     * @return
     * author TuyenDV
     */

    @GetMapping("/getListCategory")
    public ResponseEntity<List<ProductCategory>> getListCategory(){
        try{
            List<ProductCategory> productCategories = productCategoryService.findlistCategory();
            if(productCategories.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(productCategories,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
