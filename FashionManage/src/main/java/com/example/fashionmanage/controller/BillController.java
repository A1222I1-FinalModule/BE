package com.example.fashionmanage.controller;

import com.example.fashionmanage.service.BillService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class BillController {
  @Autowired
  private BillService billService;

  @GetMapping("/saler/get_revenue_by_week")
  public Double getRevenueByWeek() {
    return billService.calculateRevenueByWeek();
  }

  // @GetMapping("/saler/get_revenue_by_month")
  // public Double getRevenueByMonth() {
  //   return billService.calculateRevenueByMonth("12") == 0.0 ? 0.0 : billService.calculateRevenueByMonth(month);
  // }
  @GetMapping("/saler/get_revenue_by_month/{month}")
  public Double getRevenueByMonth(@PathVariable("month") String month) {
    Double revenue = billService.calculateRevenueByMonth(month);
    return revenue == 0.0 ? 0.0 : revenue;
  }
}

