package com.example.fashionmanage.service;

import java.util.List;

public interface StatisticalService {
  List<Object[]> getStatisticalByMonth();
  List<Object[]> getStatisticalByDate();
  List<Object[]> getDailyStastistical(String date);
  List<Object[]> getMonthlyStastistical(String month);
}
