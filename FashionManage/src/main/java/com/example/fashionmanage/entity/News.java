package com.example.fashionmanage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "news", schema = "fashionShop")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "title")
    private String title;


    @Size(max = 1000)
    @Column(name = "content")
    private String content;


    @Column(name = "image")
    private String image;

    @Size(max = 255)
    @Column(name = "creator")
    private String creator;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id")
    private Tag tag;

}