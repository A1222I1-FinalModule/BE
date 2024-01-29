package com.example.fashionmanage.controller;

import java.util.*;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

  @GetMapping("/statistical/monthly")
  public List<Object[]> getStatisticalByMonth() {
    return statisticalService.getStatisticalByMonth();
  }

  @GetMapping("/statistical/daily")
  public List<Object[]> getStatisticalByDate() {
    return statisticalService.getStatisticalByDate();
  }

  /**
   * The function help get daily statistical
   * @param date
   * @author NhanNNB
   * @return list data of daily statistical
   */
  @GetMapping("/daily/{date}")
  public List<Object[]> getDailyStastistical(@PathVariable(required = false) String date) {
    if (date == null) {
      return Collections.emptyList();
    } else {
      return statisticalService.getDailyStastistical(date);
    }
  }

  /**
   * The function help get monthly statistical
   * @param month
   * @author NhanNNB
   * @return list data of monthly statistical
   */
  @GetMapping("/monthly/{month}")
  public List<Object[]> getMonthlyStastiList(@PathVariable(required = false) String month) {
    if (month == null) {
      return Collections.emptyList();
    } else {
      return statisticalService.getMonthlyStastistical(month);
    }
  }

}
