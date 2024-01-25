package com.example.fashionmanage.service;

import java.util.List;
import org.springframework.stereotype.Service;

public interface StatisticalService {
  List<Object[]> getStatisticalByMonth();
  List<Object[]> getStatisticalByDate();
}
