package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.News;
import com.example.fashionmanage.service.news.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("/list")
    public ResponseEntity<List<News>> findAllNews() {
        List<News> newsList = newsService.findAllNews();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody News news) {
        try {
            newsService.createNews(news);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
