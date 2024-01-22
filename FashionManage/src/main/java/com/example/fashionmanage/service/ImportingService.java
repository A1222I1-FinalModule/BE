package com.example.fashionmanage.service;

import java.util.List;

import com.example.fashionmanage.entity.Importing;

public interface ImportingService {
  List<Importing> getAllImporting();

  List<Importing> getImportingByDate();

  List<Importing> getImportingByMonth();

  void saveImporting(Importing importing);
}
