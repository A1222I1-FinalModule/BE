package com.example.fashionmanage.repository;

import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.GetBillDTO;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {
        /**
         * The Function to display list of bills in this month
         *
         * @return list of bills in this month
         * @author NhanNNB
         */
        @Query(value = "SELECT b.release_date AS order_date, total, c.name AS customer_name " +
                        "FROM bill b JOIN customer c ON b.customer_id = c.id " +
                        "WHERE MONTH(release_date) = MONTH(NOW()) " +
                        "ORDER BY b.release_date DESC;", nativeQuery = true)
        List<Object[]> findBillsInMonth();
    /**
     * The Function to display list of 5 latest orders
     *
     * @return list data of 5 latest orders
     * @author ThanhBM
     */
    @Query(value = "SELECT b.release_date AS orderDate, c.name AS customerName " +
            "FROM bill b " +
            "JOIN customer c ON b.customer_id = c.id " +
            "ORDER BY b.release_date DESC " +
            "LIMIT 5", nativeQuery = true)
    List<GetBillDTO> findTop5RecentOrders();

        /**
         * The Function to display Customer Growth Percentage
         *
         * @return array of Customer Growth Percentage
         * @author ThanhBM
         */
        @Query(value = "SELECT COUNT(DISTINCT customer_id) AS customerCount, " +
                        "(COUNT(DISTINCT customer_id) - COALESCE(LAG(COUNT(DISTINCT customer_id)) OVER (ORDER BY MONTH(release_date)), 0)) AS customerGrowthPercentage "
                        +
                        "FROM bill " +
                        "WHERE MONTH(release_date) = MONTH(CURRENT_DATE)", nativeQuery = true)
        List<CustomerGrowth> calculateCustomerGrowthPercentage();

        /**
         * The Function to display Order Growth Percentage
         *
         * @return data of Order Growth Percentage
         * @author ThanhBM
         */
        @Query(value = "SELECT COUNT(*) AS orderCount, " +
                        "(COUNT(*) - (" +
                        "    SELECT COUNT(*) " +
                        "    FROM bill " +
                        "    WHERE MONTH(release_date) = MONTH(CURRENT_DATE) - 1" +
                        ")) AS orderGrowthPercentage " +
                        "FROM bill " +
                        "WHERE MONTH(release_date) = MONTH(CURRENT_DATE)", nativeQuery = true)
        List<OrderGrowthDTO> calculateOrderGrowthPercentage();

        /**
         * The function count revenue by day
         *
         * @return data of revenue by day
         * @author NhanNNB
         */
        @Query(value = "SELECT SUM(total) AS daily_revenue " +
                        "FROM bill " +
                        "WHERE YEAR(release_date) = YEAR(NOW()) AND MONTH(release_date) = MONTH(NOW()) AND DAY(release_date) = DAY(NOW());", nativeQuery = true)
        Double calculateRevenueByDay();

        /**
         * The function count revenue by week
         *
         * @return data of revenue by week
         * @author ThanhBM
         */
        @Query(value = "SELECT SUM(total) AS weekly_revenue " +
                        "FROM bill " +
                        "WHERE YEAR(release_date) = YEAR(NOW()) AND WEEK(release_date) = WEEK(NOW())", nativeQuery = true)
        Double calculateRevenueByWeek();

        /**
         * The function count revenue by months
         *
         * @return data of revenue by months
         * @author ThanhBM
         */
        @Query(value = "SELECT SUM(total) AS monthly_revenue " +
                        "FROM bill " +
                        "WHERE YEAR(release_date) = YEAR(NOW()) AND MONTH(release_date) = MONTH(NOW())", nativeQuery = true)
        Double calculateRevenueByMonth();
}
