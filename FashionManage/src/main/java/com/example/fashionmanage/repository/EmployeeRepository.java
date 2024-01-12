package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query(value = "SELECT e.name AS employee_name, " +
            "SUM(b.total) AS total_sales, " +
            "COUNT(b.id) AS total_orders " +
            "FROM Employee e " +
            "JOIN Bill b ON e.id = b.employee.id " +
            "GROUP BY e.id, e.name " +
            "ORDER BY total_sales DESC LIMIT 5", nativeQuery = true)
    List<Employee> findAllEmployeeSaleTop();
    /**
     * Method : findByUser
     * <p>Return Employee from user id</p>
     * @param id
     * @return Employee
     * @author AiPV
     */
    @Query(value = "SELECT e.id,e.address,e.date_of_birth,e.name,e.phone,e.user_id FROM employee e WHERE e.user_id = :id", nativeQuery = true)
    Employee findByUser(@Param("id")Integer id);


}
