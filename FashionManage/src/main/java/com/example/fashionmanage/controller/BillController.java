package com.example.fashionmanage.controller;


import com.example.fashionmanage.dto.CustomerGrowth;
import com.example.fashionmanage.dto.GetBillDTO;
import com.example.fashionmanage.dto.OrderGrowthDTO;
import com.example.fashionmanage.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillService billService;

    /**
     * Get the list of bills by the bill service for warehouse.
     * 
     * @return ResponseEntity containing the list of bills if available, or a
     *         NOT_FOUND response if not.
     * @author NhanNNB
     */
    @GetMapping({ "/saler/bill", "/warehouse/bill", "/admin/bill" })
    public ResponseEntity<List<Object[]>> getAllBills() {
        List<Object[]> bills = billService.getAllBill();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    /**
     * Get the daily revenue calculated by the bill service.
     * 
     * @return ResponseEntity containing the daily revenue if available, or a
     *         NOT_FOUND response if not.
     * @author NhanNNB
     */
    @GetMapping({ "/warehouse/daily/revenue", "/saler/daily/revenue", "/admin/daily/revenue" })
    public ResponseEntity<Double> getDailyRevenue() {
        Double dailyRevenue = billService.calculateRevenueByDay();
        return new ResponseEntity<>(dailyRevenue, HttpStatus.OK);
    }

    /**
     * Get the weekly revenue calculated by the bill service.
     * 
     * @return ResponseEntity containing the weekly revenue if available, or a
     *         NOT_FOUND response if not.
     * @author NhanNNB
     */
    @GetMapping({ "/saler/weekly/revenue", "/warehouse/weekly/revenue", "/admin/weekly/revenue" })
    public ResponseEntity<Double> getWeeklyRevenue() {
        Double weeklyRevenue = billService.calculateRevenueByWeek();
        return new ResponseEntity<>(weeklyRevenue, HttpStatus.OK);
    }

    /**
     * Get the monthly revenue calculated by the bill service.
     * 
     * @return ResponseEntity containing the monthly revenue if available, or a
     *         NOT_FOUND response if not.
     * @author NhanNNB
     */
    @GetMapping({ "/saler/monthly/revenue", "/warehouse/monthly/revenue", "/admin/monthly/revenue" })
    public ResponseEntity<Double> getMonthlyRevenue() {
        Double monthRevenue = billService.calculateRevenueByWeek();
        return new ResponseEntity<>(monthRevenue, HttpStatus.OK);
    }

    /**
     * Get the top 5 recent orders as returned by the bill service.
     *
     * @return ResponseEntity containing a list of Object arrays representing recent
     *         orders if available,
     *         or a NOT_FOUND response if the list is empty.
     */
    @GetMapping("/admin/orders-top")
    public ResponseEntity<List<GetBillDTO>> getTop5RecentOrders() {
        List<GetBillDTO> bill = billService.getTop5RecentOrder();
        if (bill.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bill, HttpStatus.OK);
        }
    }

    /**
     * Calculate the customer growth percentage based on the data provided by the
     * bill service.
     *
     * @return ResponseEntity containing an Object array representing customer
     *         growth if available,
     *         or a NOT_FOUND response if the array is null or empty.
     */
    @GetMapping("/admin/customer-growth")
    public ResponseEntity<List<CustomerGrowth>> calculateCustomerGrowthPercentage() {
        List<CustomerGrowth> customerGrowth = billService.calculateCustomerGrowthPercentage();
        if (customerGrowth.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerGrowth, HttpStatus.OK);
        }
    }

    /**
     * Calculate the order growth percentage based on the data provided by the bill
     * service.
     *
     * @return ResponseEntity containing an Object array representing order growth
     *         if available,
     *         or a NOT_FOUND response if the array is null or empty.
     */
    @GetMapping("/admin/order-growth")
    public ResponseEntity<List<OrderGrowthDTO>> calculateOrderGrowthPercentage() {
        List<OrderGrowthDTO> orderGrowth = billService.calculateOrderGrowthPercentage();
        if (orderGrowth.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(orderGrowth, HttpStatus.OK);
        }
    }
}
