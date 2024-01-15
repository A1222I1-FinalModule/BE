package com.example.fashionmanage.service;

import com.example.fashionmanage.dto.EmployeeDTO;
import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;

import java.util.Optional;
import java.util.List;

import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;

public interface EmployeeService {
    Employee getInfo(User user);

    List<EmployeeDTO> getEmployeeSaleTop();
    Optional<Employee> findById(String id);
    public Employee getInfo(User user);
    String getEmployeeCodeByUserId(Integer user_id);
}
