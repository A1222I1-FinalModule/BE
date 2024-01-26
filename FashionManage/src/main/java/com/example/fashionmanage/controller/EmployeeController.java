package com.example.fashionmanage.controller;
import com.example.fashionmanage.dto.EmployeeDTO;
import com.example.fashionmanage.repository.UserRepository;
import com.example.fashionmanage.service.EmployeeServiceImpl;
import com.example.fashionmanage.util.JwtUtil;
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
@RequestMapping({"/api/admin", "/api/saler", "/api/warehouse"})
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepo;


    @GetMapping("/employee-top")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeSaleTop() {
        List<EmployeeDTO> employee = employeeService.getEmployeeSaleTop();
        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }
}
