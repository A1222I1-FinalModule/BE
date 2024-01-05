package com.example.fashionmanage.service;

import java.util.List;

import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;

public interface EmployeeService {
    List<Object[]> getEmployeeSaleTop();
    Employee getInfo(User user);
}
