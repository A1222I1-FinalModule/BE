package com.example.fashionmanage.controller;


import com.example.fashionmanage.entity.Bill;
import com.example.fashionmanage.service.BillService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    /**
     * Get the weekly revenue calculated by the bill service.
     *
     * @return ResponseEntity containing the weekly revenue if available, or a NOT_FOUND response if not.
     */
    @GetMapping("/weekly/revenue")
    public ResponseEntity<Double> getWeeklyRevenue() {
        Double weeklyRevenue = billService.calculateRevenueByWeek();
        if (weeklyRevenue != null) {
            return new ResponseEntity<>(weeklyRevenue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Get the monthly revenue calculated by the bill service.
     *
     * @return ResponseEntity containing the monthly revenue if available, or a NOT_FOUND response if not.
     */
    @GetMapping("/month/revenue")
    public ResponseEntity<Double> getMonthRevenue() {
        Double monthRevenue = billService.calculateRevenueByWeek();
        if (monthRevenue != null) {
            return new ResponseEntity<>(monthRevenue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Get the top 5 recent orders as returned by the bill service.
     *
     * @return ResponseEntity containing a list of Object arrays representing recent orders if available,
     *         or a NOT_FOUND response if the list is empty.
     */
    @GetMapping("/orders-top")
    public ResponseEntity<List<Object[]>> getTop5RecentOrders() {
        List<Object[]> bill = billService.getTop5RecentOrder();
        if (bill.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bill, HttpStatus.OK);
        }
    }
    /**
     * Calculate the customer growth percentage based on the data provided by the bill service.
     *
     * @return ResponseEntity containing an Object array representing customer growth if available,
     *         or a NOT_FOUND response if the array is null or empty.
     */
    @GetMapping("/customer-growth")
    public ResponseEntity<Object[]> calculateCustomerGrowthPercentage() {
        Object[] customerGrowth = billService.calculateCustomerGrowthPercentage();
        if (customerGrowth != null && customerGrowth.length > 0) {
            return new ResponseEntity<>(customerGrowth, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Calculate the order growth percentage based on the data provided by the bill service.
     *
     * @return ResponseEntity containing an Object array representing order growth if available,
     *         or a NOT_FOUND response if the array is null or empty.
     */
    @GetMapping("/order-growth")
    public ResponseEntity<Object[]> calculateOrderGrowthPercentage() {
        Object[] orderGrowth = billService.calculateOrderGrowthPercentage();
        if (orderGrowth != null && orderGrowth.length > 0) {
            return new ResponseEntity<>(orderGrowth, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
