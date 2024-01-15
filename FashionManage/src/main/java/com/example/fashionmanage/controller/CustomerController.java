package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/admin")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

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
        /**
         * The function help display all data of list customer
         *
         * @return list data of customer
         * @author QuanNV
         */
        @GetMapping("/listCustomer")
        public ResponseEntity<List<Customer>> findAllDiscount () {
            List<Customer> customers = customerService.findAllCustomer();
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }

        /**
         * The function help delete all data of customer find by id
         *
         * @param id is code of customer
         * @return
         * @author QuanNV
         */
        @DeleteMapping("/deleteByIdCustomer")
        public ResponseEntity<?> deleteByIdCustomer (@RequestParam("id") String id){
            Customer customer = customerService.findByIdCustomer(id);
            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            customerService.deleteByIdCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        /**
         * The function help display all data of customer find by name
         *
         * @param name is code of customer
         * @return data of customer find by customer
         * @author QuanNV
         */
        @GetMapping("/findByNameCustomer")
        public ResponseEntity<?> findByNameCustomer (@RequestParam("name") String name){
            List<Customer> customer = customerService.findByNameCustomer(name);
            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
}
