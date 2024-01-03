
package com.example.fashionmanage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "notification", schema = "fashionShop")
public class Notification {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "start_date", nullable = false)
    @DateTimeFormat
    private Date startDate;

    @NotNull
    @Column(name = "content", nullable = false,columnDefinition = "text")
    private String content;


    private  int target;

    private Boolean status;

}

