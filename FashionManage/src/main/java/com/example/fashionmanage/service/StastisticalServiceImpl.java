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
  public List<Object[]> getStatisticalByMonth(String month) {
    return importingRepository.getStatisticalByMonth(month);
  }

  @Override
  public List<Object[]> getStatisticalByDate(String date) {
    return importingRepository.getStatisticalByDate(date);
  }

}
