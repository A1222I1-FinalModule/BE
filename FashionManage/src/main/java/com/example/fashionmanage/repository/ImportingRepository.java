package com.example.fashionmanage.repository;

import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fashionmanage.entity.Importing;

public interface ImportingRepository extends JpaRepository<Importing, Integer> {

        @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW()) AND MONTH(import_date) = MONTH(NOW()) AND DAY(import_date) = DAY(NOW())", nativeQuery = true)
        List<Importing> findImportingByDate();

        @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW()) AND MONTH(import_date) = MONTH(NOW())", nativeQuery = true)
        List<Importing> findImportingByMonth();

        @Query(value = "SELECT MAX(id) AS current_max_id FROM importing;", nativeQuery = true)
        Integer getCurrentMaxId();

        @Query(value = "WITH CombinedData AS ( " +
                        "    SELECT " +
                        "        DATE(date) AS transaction_date, " +
                        "        SUM(total_revenue) AS total_revenue, " +
                        "        SUM(total_expenditure) AS total_expenditure " +
                        "    FROM ( " +
                        "        SELECT  " +
                        "            DATE(release_date) AS date, " +
                        "            total AS total_revenue, " +
                        "            0 AS total_expenditure " +
                        "        FROM bill " +
                        " " +
                        "        UNION ALL " +
                        " " +
                        "        SELECT  " +
                        "            DATE(import_date) AS date, " +
                        "            0 AS total_revenue, " +
                        "            total AS total_expenditure " +
                        "        FROM importing " +
                        "    ) AS combined_data " +
                        "    WHERE DATE_FORMAT(date, '%Y-%m') = :month " +
                        "    GROUP BY DATE(date) " +
                        ") " +
                        " " +
                        "SELECT  " +
                        "    transaction_date, " +
                        "    MAX(total_revenue) AS total_revenue, " +
                        "    MAX(total_expenditure) AS total_expenditure " +
                        "FROM CombinedData " +
                        "GROUP BY transaction_date " +
                        "ORDER BY transaction_date; " +
                        "", nativeQuery = true)
        List<Object[]> getStatisticalByMonth(@Param("month") String month);

        @Query(value = "WITH CombinedData AS (\n" + //
                        "    SELECT \n" + //
                        "        DATE(date) AS transaction_date,\n" + //
                        "        SUM(total_revenue) AS total_revenue,\n" + //
                        "        SUM(total_expenditure) AS total_expenditure\n" + //
                        "    FROM (\n" + //
                        "        SELECT \n" + //
                        "            DATE(release_date) AS date,\n" + //
                        "            total AS total_revenue,\n" + //
                        "            0 AS total_expenditure\n" + //
                        "        FROM bill\n" + //
                        "\n" + //
                        "        UNION ALL\n" + //
                        "\n" + //
                        "        SELECT \n" + //
                        "            DATE(import_date) AS date,\n" + //
                        "            0 AS total_revenue,\n" + //
                        "            total AS total_expenditure\n" + //
                        "        FROM importing\n" + //
                        "    ) AS combined_data\n" + //
                        "    WHERE DATE(date) = :date\n" + //
                        "    GROUP BY DATE(date)\n" + //
                        ")\n" + //
                        "\n" + //
                        "SELECT \n" + //
                        "    transaction_date,\n" + //
                        "    MAX(total_revenue) AS total_revenue,\n" + //
                        "    MAX(total_expenditure) AS total_expenditure\n" + //
                        "FROM CombinedData\n" + //
                        "GROUP BY transaction_date\n" + //
                        "ORDER BY transaction_date;", nativeQuery = true)
        List<Object[]> getStatisticalByDate(@Param("date") String date);

        @Query(value = "WITH CombinedData AS (\r\n" + //
                        "    SELECT \r\n" + //
                        "        DATE(date) AS transaction_date,\r\n" + //
                        "        SUM(total_revenue) AS total_revenue,\r\n" + //
                        "        SUM(total_expenditure) AS total_expenditure\r\n" + //
                        "    FROM (\r\n" + //
                        "        SELECT \r\n" + //
                        "            DATE(release_date) AS date,\r\n" + //
                        "            total AS total_revenue,\r\n" + //
                        "            0 AS total_expenditure\r\n" + //
                        "        FROM bill\r\n" + //
                        "\r\n" + //
                        "        UNION ALL\r\n" + //
                        "\r\n" + //
                        "        SELECT \r\n" + //
                        "            DATE(import_date) AS date,\r\n" + //
                        "            0 AS total_revenue,\r\n" + //
                        "            total AS total_expenditure\r\n" + //
                        "        FROM importing\r\n" + //
                        "    ) AS combined_data\r\n" + //
                        "    WHERE MONTH(date) = MONTH(NOW()) AND YEAR(date) = YEAR(NOW())\r\n" + //
                        "    GROUP BY DATE(date)\r\n" + //
                        ")\r\n" + //
                        "\r\n" + //
                        "SELECT \r\n" + //
                        "    transaction_date,\r\n" + //
                        "    MAX(total_revenue) AS total_revenue,\r\n" + //
                        "    MAX(total_expenditure) AS total_expenditure\r\n" + //
                        "FROM CombinedData\r\n" + //
                        "WHERE total_revenue > 0 OR total_expenditure > 0\r\n" + //
                        "GROUP BY transaction_date\r\n" + //
                        "ORDER BY transaction_date;\r\n", nativeQuery = true)
        List<Object[]> getMonthlyStatistical();

        @Query(value = "WITH CombinedData AS (\r\n" + //
                        "    SELECT \r\n" + //
                        "        DATE(date) AS transaction_date,\r\n" + //
                        "        SUM(total_revenue) AS total_revenue,\r\n" + //
                        "        SUM(total_expenditure) AS total_expenditure\r\n" + //
                        "    FROM (\r\n" + //
                        "        SELECT \r\n" + //
                        "            DATE(release_date) AS date,\r\n" + //
                        "            total AS total_revenue,\r\n" + //
                        "            0 AS total_expenditure\r\n" + //
                        "        FROM bill\r\n" + //
                        "\r\n" + //
                        "        UNION ALL\r\n" + //
                        "\r\n" + //
                        "        SELECT \r\n" + //
                        "            DATE(import_date) AS date,\r\n" + //
                        "            0 AS total_revenue,\r\n" + //
                        "            total AS total_expenditure\r\n" + //
                        "        FROM importing\r\n" + //
                        "    ) AS combined_data\r\n" + //
                        "    WHERE DAY(date) = DAY(NOW()) AND MONTH(date) = MONTH(NOW()) AND YEAR(date) = YEAR(NOW())\r\n"
                        + //
                        "    GROUP BY DATE(date)\r\n" + //
                        ")\r\n" + //
                        "\r\n" + //
                        "SELECT \r\n" + //
                        "    transaction_date,\r\n" + //
                        "    MAX(total_revenue) AS total_revenue,\r\n" + //
                        "    MAX(total_expenditure) AS total_expenditure\r\n" + //
                        "FROM CombinedData\r\n" + //
                        "GROUP BY transaction_date\r\n" + //
                        "ORDER BY transaction_date;\r\n", nativeQuery = true)
        List<Object[]> getDailyStatistical();

        @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW()) AND MONTH(import_date) = MONTH(NOW()) AND DAY(import_date) = DAY(NOW())", nativeQuery = true)
        List<Importing> getImportingByDate();

        @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW()) AND MONTH(import_date) = MONTH(NOW())", nativeQuery = true)
        List<Importing> getImportingByMonth();

        @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW())", nativeQuery = true)
        List<Importing> getImportingByYear();
}
