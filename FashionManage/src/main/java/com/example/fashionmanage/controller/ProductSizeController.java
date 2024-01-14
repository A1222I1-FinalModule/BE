package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Notification;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.ProductSize;
import com.example.fashionmanage.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/warehouse")
public class ProductSizeController {
    @Autowired
    private ProductSizeService productSizeService;
    /**
     * The function help list product
     * @return
     * author TuyenDV
     */
    @GetMapping("/getListProductSize")
    public ResponseEntity<List<ProductSize>> getAllInfoProduct(){
        try{
            List<ProductSize> productSizes = productSizeService.findListProductSize();
            if(productSizes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(productSizes,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * The function help findById ProductSize
     * @return
     * author TuyenDV
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductSize> findByIdProductSize(@PathVariable("id") Integer id) {
        {
            ProductSize productSize = productSizeService.findByIdProductSize(id);
            if (productSize.getId() == 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productSize, HttpStatus.OK);
        }
    }
}
