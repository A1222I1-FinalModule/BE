package com.example.fashionmanage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashionmanage.service.StatisticalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("*")
@RestController()
@RequestMapping({ "/api/saler", "/api/admin", "/api/warehouse" })
public class StatisticalController {
  @Autowired
  private StatisticalService statisticalService;

  @GetMapping("/statistical/month/{month}")
  public List<Object[]> getStatisticalByMonth(@PathVariable("month") String month) {
    return statisticalService.getStatisticalByMonth(month);
  }

  @GetMapping("/statistical/date/{date}")
  public List<Object[]> getStatisticalByDate(@PathVariable("date") String date){
    return statisticalService.getStatisticalByDate(date);
  }

}
