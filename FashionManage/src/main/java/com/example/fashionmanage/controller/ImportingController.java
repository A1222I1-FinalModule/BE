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
@RequestMapping("/api")
public class ImportingController {
  @Autowired
  private ImportingService importingService;

  @GetMapping({ "/admin/importing", "/warehouse/importing", "/saler/importing" })
  public List<Importing> getImportings() {
    return importingService.getAllImporting();
  }

  @GetMapping({ "/admin/importing/date", "/warehouse/importing/date", "/saler/importing/date" })
  public List<Importing> getImportingsByDate() {
    return importingService.getImportingByDate();
  }

  @GetMapping({ "/admin/importing/month", "/warehouse/importing/month", "/saler/importing/month" })
  public List<Importing> getImportingsByMonth() {
    return importingService.getImportingByMonth();
  }

  @PostMapping({ "admin/importing", "/warehouse/importing", "/saler/importing" })
  public void addImporting(@RequestBody Importing importing) {
    importingService.saveImporting(importing);
  }

  @GetMapping({ "admin/importing/maxId", "warehouse/importing/maxId" })
  public Integer getCurrentMaxId() {
    return importingService.getCurrentMaxId();
  }
}
