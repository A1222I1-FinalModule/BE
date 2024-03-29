package com.example.fashionmanage.service;


import com.example.fashionmanage.dto.EmployeeDTO;
import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;
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
    public List<EmployeeDTO> getEmployeeSaleTop() {
        return employeeRepository.findAllEmployeeSaleTop();
    }
    /**
     * Method : getInfo
     * <p>Return Employee from user</p>
     * @param user
     * @return Employee
     * @author AiPV
     */
    public Employee getInfo(User user) {
        return employeeRepository.findByUser(user.getId());
    }

    @Override
    public String getEmployeeCodeByUserId(Integer user_id) {
        return employeeRepository.getEmployeeCodeByUserId(user_id);
    }
}