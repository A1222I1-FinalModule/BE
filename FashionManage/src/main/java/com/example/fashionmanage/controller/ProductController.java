package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.service.EmployeeServiceImpl;
import com.example.fashionmanage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/public")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private EmployeeServiceImpl employeeService;

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

    @GetMapping("/findByProductCategories")
    public ResponseEntity<?> findByNameProduct (@RequestParam(value = "id" ,required = false) Integer id ){
        List<Product> products = productService.findByProductCategories(id);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/update-quantity/{quantity}")
    public void UpdateQuantity(@PathVariable Integer quantity,@RequestBody Product product) {
        productService.updateQuantity(quantity, product);
    }


    /**
     * Method : getUserInfo
     * <p>get Employee Information of current user</p>
     * @return Employee
     * @author AiPV
     */
    @GetMapping("/info")
    private ResponseEntity<Employee> getUserInfo(@AuthenticationPrincipal User user) {
        Employee employee = employeeService.getInfo(user);
        return ResponseEntity.ok(employee);
    }
}
