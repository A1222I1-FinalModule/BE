package com.example.fashionmanage.service;

import com.example.fashionmanage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Object[]> getEmployeeSaleTop() {
        return employeeRepository.findAllEmployeeSaleTop();
    }
}
