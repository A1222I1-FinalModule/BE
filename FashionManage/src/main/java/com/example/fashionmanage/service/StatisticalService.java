package com.example.fashionmanage.service;

import java.util.List;

public interface StatisticalService {
  List<Object[]> getStatisticalByMonth(String month);
  List<Object[]> getStatisticalByDate(String date);
}
