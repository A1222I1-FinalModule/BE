package com.example.fashionmanage.controller;

import com.example.fashionmanage.dto.EmployeeDTO;
import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.service.EmployeeService;
import com.example.fashionmanage.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/admin")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employee-top")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeSaleTop() {
        List<EmployeeDTO> employee = employeeService.getEmployeeSaleTop();
        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }
//    @GetMapping("/info")
//    private ResponseEntity<Employee> getUserInfo(@AuthenticationPrincipal User user) {
//        Employee employee = employeeService.getInfo(user);
//        return ResponseEntity.ok(employee);
//    }
}
