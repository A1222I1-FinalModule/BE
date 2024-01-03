package com.example.fashionmanage.controller;

import com.example.fashionmanage.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class BillController {
  @Autowired
  private BillService billService;

  @GetMapping("/saler/get_revenue_by_week")
  public Double getRevenueByWeek(@RequestParam String week) {
    return billService.calculateRevenueByWeek();
  }

  @GetMapping("/saler/get_revenue_by_month/{month}")
  public Double getRevenueByMonth(@RequestParam Integer month) {
    return billService.calculateRevenueByMonth(month);
  }
}

