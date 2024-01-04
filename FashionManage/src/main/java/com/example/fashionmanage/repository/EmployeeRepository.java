package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    /**
     * The Function to display list of 5 Employee Sale Top
     * @author ThanhBM
     * @return list array of 5 Employee Sale Top
     */
    @Query(value = "SELECT e.name AS employee_name, " +
            "SUM(b.total) AS total_sales, " +
            "COUNT(b.id) AS total_orders " +
            "FROM employee e " +
            "JOIN bill b ON e.id = b.employee_id " +
            "GROUP BY e.id, e.name " +
            "ORDER BY total_sales DESC LIMIT 5", nativeQuery = true)
    List<Object[]> findAllEmployeeSaleTop();
}
