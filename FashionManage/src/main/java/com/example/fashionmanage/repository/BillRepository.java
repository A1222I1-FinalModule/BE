package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {
        /**
         * The Function to display list of 5 latest orders
         *
         * @return list data of 5 latest orders
         * @author ThanhBM
         */
        @Query(value = "SELECT b.release_date AS order_date, c.name AS customer_name " +
                        "FROM bill b " +
                        "JOIN customer c ON b.customer_id = c.id " +
                        "ORDER BY b.release_date DESC " +
                        "LIMIT 5", nativeQuery = true)
        List<Object[]> findTop5RecentOrders();

        /**
         * The Function to display Customer Growth Percentage
         *
         * @return array of Customer Growth Percentage
         * @author ThanhBM
         */
        @Query(value = "SELECT COUNT(DISTINCT customer_id) AS customer_count, " +
                        "(COUNT(DISTINCT customer_id) - COALESCE(LAG(COUNT(DISTINCT customer_id)) OVER (ORDER BY MONTH(release_date)), 0)) AS customer_growth_percentage "
                        +
                        "FROM bill " +
                        "WHERE MONTH(release_date) = MONTH(CURRENT_DATE)", nativeQuery = true)
        Object[] calculateCustomerGrowthPercentage();

        /**
         * The Function to display Order Growth Percentage
         *
         * @return data of Order Growth Percentage
         * @author ThanhBM
         */
        @Query(value = "SELECT COUNT(*) AS order_count, " +
                        "(COUNT(*) - (" +
                        "    SELECT COUNT(*) " +
                        "    FROM bill " +
                        "    WHERE MONTH(release_date) = MONTH(CURRENT_DATE) - 1" +
                        ")) AS order_growth_percentage " +
                        "FROM bill " +
                        "WHERE MONTH(release_date) = MONTH(CURRENT_DATE)", nativeQuery = true)
        Object[] calculateOrderGrowthPercentage();

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
