package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployeeSaleTop() {
        return employeeRepository.findAllEmployeeSaleTop();
    }

    @Override
    public String getEmployeeCodeByUserId(Integer user_id) {
        return employeeRepository.getEmployeeCodeByUserId(user_id);
    }
}
