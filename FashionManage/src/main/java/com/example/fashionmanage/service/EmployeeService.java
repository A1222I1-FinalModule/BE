package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(String id);
}
