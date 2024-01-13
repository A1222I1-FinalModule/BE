package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/admin")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list-customer")
    private List<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping("/insert-customer")
    ResponseEntity<?> saveCustomer(@RequestBody Customer newCustomer) {
        try {
            customerService.save(newCustomer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PutMapping("/update-customer/{id}")
    ResponseEntity<?> updateCustomer(@PathVariable String id,
                                     @RequestBody Customer newCustomer) {
        try {
            customerService.update(id, newCustomer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
