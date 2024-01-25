package com.example.fashionmanage.service.impl;

import com.example.fashionmanage.entity.CustomerType;
import com.example.fashionmanage.repository.CustomerTypeRepository;
import com.example.fashionmanage.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}
