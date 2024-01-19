package com.example.fashionmanage.repository;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StatisticalRepository {
  @Query(value = "WITH CombinedData AS ( " +
      "SELECT " +
      "DATE_FORMAT(date, '%Y-%m') AS month_year, " +
      "SUM(total_revenue) AS total_revenue, " +
      "SUM(total_expenditure) AS total_expenditure " +
      "FROM (" +
      "SELECT " +
      "DATE(release_date) AS date, " +
      "total AS total_revenue, " +
      "0 AS total_expenditure " +
      "FROM bill " +
      "UNION ALL " +
      "SELECT " +
      "DATE(import_date) AS date, " +
      "0 AS total_revenue, " +
      "total AS total_expenditure " +
      "FROM importing " +
      ") AS combined_data " +
      "WHERE DATE_FORMAT(date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m') " +
      "GROUP BY DATE_FORMAT(date, '%Y-%m') " +
      ")" +
      "SELECT " +
      "month_year, " +
      "MAX(total_revenue) " +
      "AS total_revenue, " +
      "MAX(total_expenditure) " +
      "AS total_expenditure " +
      "FROM CombinedData " +
      "GROUP BY month_year " +
      "ORDER BY month_year;", nativeQuery = true)
  List<Object[]> getStatisticalByMonth();

  @Query(value = "WITH CombinedData AS ( " +
      "SELECT " +
      "DATE(date) AS transaction_date, " +
      "SUM(total_revenue) AS total_revenue, " +
      "SUM(total_expenditure) AS total_expenditure " +
      "FROM ( " +
      "SELECT " +
      "DATE(release_date) AS date, " +
      "total AS total_revenue, " +
      "0 AS total_expenditure " +
      "FROM bill " +
      "UNION ALL " +
      "SELECT " +
      "DATE(import_date) AS date, " +
      "0 AS total_revenue, " +
      "total AS total_expenditure " +
      "FROM importing " +
      ") AS combined_data " +
      "WHERE DAY(date) = DAY(NOW()) AND MONTH(date) = MONTH(NOW()) AND YEAR(date) = YEAR(NOW()) " +
      "GROUP BY DATE(date) " +
      ") " +
      "SELECT " +
      "transaction_date, " +
      "MAX(total_revenue) AS total_revenue, " +
      "MAX(total_expenditure) AS total_expenditure " +
      "FROM CombinedData " +
      "GROUP BY transaction_date " +
      "ORDER BY transaction_date;", nativeQuery = true)
  List<Object[]> getStatisticalByDay();

}