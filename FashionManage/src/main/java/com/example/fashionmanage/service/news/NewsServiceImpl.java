package com.example.fashionmanage.service.news;

import com.example.fashionmanage.entity.News;
import com.example.fashionmanage.repository.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findAllNews() {
        return newsRepository.findAllNews();
    }

    @Override
    public void createNews(News news) {
        newsRepository.createNew(news);
    }

    @Override
    public News findNewsById(Long id) {
        return newsRepository.findNewsById(id);
    }

}
