package com.example.fashionmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashionmanage.entity.Importing;
import com.example.fashionmanage.repository.ImportingRepository;

@Service
public class ImportingServiceImpl implements ImportingService {
  @Autowired
  private ImportingRepository importingRepository;

  @Override
  public List<Importing> getAllImporting() {
    return importingRepository.findAll();
  }

  @Override
  public List<Importing> getImportingByDate() {
    return importingRepository.findImportingByDate();
  }

  @Override
  public List<Importing> getImportingByMonth() {
    return importingRepository.findImportingByMonth();
  }

  @Override
  public void saveImporting(Importing importing) {
    if (importing != null) {
      importingRepository.save(importing);
    } else {
      throw new NullPointerException("Importing is null");
    }
  }

  @Override
  public Integer getCurrentMaxId() {
    return importingRepository.getCurrentMaxId();
  }
}
