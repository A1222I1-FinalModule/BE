package com.example.fashionmanage.repository.news;

import com.example.fashionmanage.entity.News;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Query(value = "SELECT * FROM fashionShop.news", nativeQuery = true)
    List<News> findAllNews();

    @Modifying
    @Query(value = "INSERT INTO fashionShop.news (title, content, image, creator, tag_id) VALUES (:#{#news.title}, :#{#news.content}, :#{#news.image}, :#{#news.creator}, :#{#news.tag.id})", nativeQuery = true)
    @Transactional
    void createNew(@Param("news") News news);

    @Query(value = "SELECT news FROM fashionShop.news WHERE id = :id", nativeQuery = true)
    News findNewsById(@Param("id") Long id);
}
