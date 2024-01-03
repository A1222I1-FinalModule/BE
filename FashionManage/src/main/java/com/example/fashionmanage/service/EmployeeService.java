package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Employee;
import java.util.Optional;
import java.util.List;

public interface EmployeeService {
    Optional<Employee> findById(String id);
    List<Employee> getEmployeeSaleTop();
}
