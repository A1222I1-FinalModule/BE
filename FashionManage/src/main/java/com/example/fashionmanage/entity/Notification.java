
package com.example.fashionmanage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "notification", schema = "fashionShop")
public class Notification {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;


    @NotNull
    @Column(name = "content", nullable = false,columnDefinition = "text")
    private String content;

    private  int target;

    private Boolean status;

}

