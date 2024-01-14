package com.example.fashionmanage.controller;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/warehouse")

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
    public ResponseEntity<?> saveInfoProduct(@RequestBody @Valid Product product , BindingResult bindingResult){
//        try {
//            String idProduct = "H-" + ((int) Math.random() * 1000);
//            product.setProductCode(idProduct);
//            productService.createInfoProduct(product);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            String idProduct = "H-" + Math.random() * 1000;
            product.setProductCode(idProduct);
            productService.createInfoProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
