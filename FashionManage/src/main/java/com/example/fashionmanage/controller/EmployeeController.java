package com.example.fashionmanage.controller;

import com.example.fashionmanage.dto.EmployeeDTO;
import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.repository.UserRepository;
import com.example.fashionmanage.service.EmployeeServiceImpl;

import com.example.fashionmanage.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/admin")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepo;
    /**
     * Method : getUserInfo
     * <p>get Employee Information of current user</p>
     * @return Employee
     * @author AiPV
     */
    @GetMapping("/info")
    public ResponseEntity<Employee> getUserInfo(@AuthenticationPrincipal User user) {
        Employee employee = employeeService.getInfo(user);
        return ResponseEntity.ok(employee);
    }

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
