package com.example.fashionmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashionmanage.repository.ImportingRepository;

@Service
public class StastisticalServiceImpl implements StatisticalService {
  @Autowired
  private ImportingRepository importingRepository;

  @Override
  public List<Object[]> getStatisticalByMonth() {
    return importingRepository.getDailyStatistical();
  }

  @Override
  public List<Object[]> getStatisticalByDate() {
    return importingRepository.getMonthlyStatistical();
  }

  @Override
  public List<Object[]> getDailyStastistical(String date) {
    return importingRepository.getStatisticalByDate(date);
  }

  @Override
  public List<Object[]> getMonthlyStastistical(String month) {
    return importingRepository.getStatisticalByMonth(month);
  }

}
