package com.example.fashionmanage.service.news;

import com.example.fashionmanage.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAllNews();
    void createNews(News news);
}
