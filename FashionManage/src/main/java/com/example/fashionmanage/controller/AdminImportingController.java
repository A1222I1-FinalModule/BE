package com.example.fashionmanage.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashionmanage.entity.Importing;
import com.example.fashionmanage.service.ImportingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/admin")
public class AdminImportingController {
  @Autowired
  private ImportingService importingService;

  @GetMapping("/importing")
  public List<Importing> getImportings() {
    return importingService.getAllImporting();
  }

  @GetMapping("/importing/date")
  public List<Importing> getImportingsByDate() {
    return importingService.getImportingByDate();
  }

  @GetMapping("/importing/month")
  public List<Importing> getImportingsByMonth() {
    return importingService.getImportingByMonth();
  }

  @PostMapping("/importing")
  public void addImporting(@RequestBody Importing importing) {
    importingService.saveImporting(importing);
  }

}
