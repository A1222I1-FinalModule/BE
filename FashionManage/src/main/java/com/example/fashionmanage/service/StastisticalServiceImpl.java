package com.example.fashionmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashionmanage.repository.StatisticalRepository;

@Service
public class StastisticalServiceImpl implements StatisticalService {
  @Autowired
  private StatisticalRepository statisticalRepository;

  @Override
  public List<Object[]> getStatisticalByMonth() {
    return statisticalRepository.getStatisticalByMonth();
  }

  @Override
  public List<Object[]> getStatisticalByDate() {
    return statisticalRepository.getStatisticalByDay();
  }

}
