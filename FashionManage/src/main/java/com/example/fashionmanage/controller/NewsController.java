package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.News;
import com.example.fashionmanage.service.news.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("/public/news")
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsService.findAllNews();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/public/news/{id}")
    public  ResponseEntity<News> getNews(@PathVariable Long id) {
        News news = newsService.findNewsById(id);

        if (news != null) {
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin/news/create")
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
