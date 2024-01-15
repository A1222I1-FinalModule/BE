package com.example.fashionmanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fashionmanage.entity.Importing;

public interface ImportingRepository extends JpaRepository<Importing, Integer> {

  @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW()) AND MONTH(import_date) = MONTH(NOW()) AND DAY(import_date) = DAY(NOW())", nativeQuery = true)
  List<Importing> findImportingByDate();

  @Query(value = "SELECT * FROM importing WHERE YEAR(import_date) = YEAR(NOW()) AND MONTH(import_date) = MONTH(NOW())", nativeQuery = true)
  List<Importing> findImportingByMonth();
  
}
