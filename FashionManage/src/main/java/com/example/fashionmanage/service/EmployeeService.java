package com.example.fashionmanage.service;

import com.example.fashionmanage.dto.EmployeeDTO;

import java.util.List;

import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;

public interface EmployeeService {
    Employee getInfo(User user);

    List<EmployeeDTO> getEmployeeSaleTop();
}
