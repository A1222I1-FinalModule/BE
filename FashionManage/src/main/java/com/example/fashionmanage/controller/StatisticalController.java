package com.example.fashionmanage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashionmanage.service.StatisticalService;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/saler")
public class StatisticalController {
  @Autowired
  private StatisticalService statisticalService;

  @GetMapping("/statistical/monthly")
  public List<Object[]> getStatisticalByMonth() {
    return statisticalService.getStatisticalByMonth();
  }
  @GetMapping("/statistical/daily")
  public List<Object[]> getStatisticalByDay() {
    return statisticalService.getStatisticalByDate();
  }

}
