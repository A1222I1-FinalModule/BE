package com.example.fashionmanage.controller;
import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.service.EmployeeServiceImpl;
import com.example.fashionmanage.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public")
public class ProductController {
    @Autowired
    private EmployeeServiceImpl employeeService;
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
     * @param product1
     * @return
     * author TuyenDV
     */
    @PostMapping("/createInfoProduct")
    public ResponseEntity<?> saveInfoProduct(@Valid @RequestBody Product product1 ){
        try {
            boolean check=productService.checkIdProduct(product1.getProductCode());
            if(check){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else{
                productService.createInfoProduct(product1);
                return new ResponseEntity<>(HttpStatus.OK);}
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<?> findByNameProduct( @RequestParam(required = false) String name,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "5") int size,
                                                @RequestParam(defaultValue = "name") String sortBy,
                                                @RequestParam(defaultValue = "asc") String sortOrder) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));

        Page<Product> products = productService.findByProduct(name, pageable);
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

    /**
     * Method : getUserInfo
     * <p>get Employee Information of current user</p>
     * @return Employee
     * @author AiPV
     */
    @GetMapping("/info")
    public ResponseEntity<Employee> getUserInfo(@AuthenticationPrincipal User user) {
        Employee employee = employeeService.getInfo(user);
        return ResponseEntity.ok(employee);
    }
    
}
