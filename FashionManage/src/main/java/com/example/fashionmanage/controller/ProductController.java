package com.example.fashionmanage.controller;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * The function help list product
     * @return
     * author TuyenDV
     */


   @GetMapping("/getListProduct")
   public ResponseEntity<List<Product>> getAllInfoProduct(){
       try{
           List<Product> products = productService.findListInfoProduct();
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
     * author TuyenDV
     */
    @PostMapping("/createInfoProduct")
    public ResponseEntity<?> saveInfoProduct(@Valid @RequestBody Product product ,BindingResult bindingResult){
//        try {
//
//            productService.createInfoProduct(product);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
//            String idProduct = "H-" + Math.random() * 1000;
//            product.setProductCode(idProduct);
            productService.createInfoProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    /**
     * The function help product all data of product find by name
     *
     * @param name is code of product
     * @return data of discount find by product
     * @author TuyenDV
     */
    @GetMapping("/findByNameProduct")
    public ResponseEntity<?> findByNameProduct (@RequestParam(value = "name" ,required = false) String name ){
        List<Product> products = productService.findByNameProduct(name);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/findByProductCodeProduct")
    public ResponseEntity<?> findByProductCodeProduct (@RequestParam(value = "product_code" ,required = false) String productCode ) {
        List<Product> products = productService.findByProductCode(productCode);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/findByProductCategories")
    public ResponseEntity<?> findByProductCategories(@RequestParam(value = "id", required = false) Integer id) {

        List<Product> products = productService.findByProductCategories(id);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    
}
