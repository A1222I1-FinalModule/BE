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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/public")
public class ImportingController {
  @Autowired
  private ImportingService importingService;

  @GetMapping("importing")
  public List<Importing> getImportings() {
    return importingService.getAllImporting();
  }

  @GetMapping("importing/daily")
  public List<Importing> getImportingsByDate() {
    return importingService.getImportingByDate();
  }

  @GetMapping("importing/monthly")
  public List<Importing> getImportingsByMonth() {
    return importingService.getImportingByMonth();
  }

  @GetMapping( "/importing/maxId")
  public Integer getCurrentMaxId() {
    return importingService.getCurrentMaxId();
  }
  @PostMapping("/importing")
    public void createImporting(@RequestBody Importing importing) {
        importingService.saveImporting(importing);
    }
}
