package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.CustomerType;
import com.example.fashionmanage.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/list-customertype")
    private List<CustomerType> getAll() {
        return customerTypeService.findAll();
    }
}
