package com.example.fashionmanage.repository;

import com.example.fashionmanage.dto.EmployeeDTO;
import com.example.fashionmanage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    /**
     * The Function to display list of 5 Employee Sale Top
     *
     * @return list array of 5 Employee Sale Top
     * @author ThanhBM
     */
    @Query(value = "SELECT e.name AS employeeName, " +
            "SUM(b.total) AS totalSales, " +
            "COUNT(b.id) AS totalOrders " +
            "FROM employee e " +
            "JOIN bill b ON e.id = b.employee_id " +
            "GROUP BY e.id, e.name " +
            "ORDER BY totalSales DESC LIMIT 5", nativeQuery = true)
    List<EmployeeDTO> findAllEmployeeSaleTop();
    /**
     * Method : findByUser
     * <p>Return Employee from user id</p>
     * @param id
     * @return Employee
     * @author AiPV
     */
    @Query(value = "SELECT e.id,e.address,e.date_of_birth,e.name,e.phone,e.image,e.user_id FROM employee e WHERE e.user_id = :id", nativeQuery = true)
    Employee findByUser(@Param("id")Integer id);

    /**
     * The function help get employee code base on user id
     *
     * @param user_id
     * @return employee Code
     * @author BaoDV
     */
    @Query(value = "select id from employee where user_id = :user_id ", nativeQuery = true)
    String getEmployeeCodeByUserId(Integer user_id);
}

