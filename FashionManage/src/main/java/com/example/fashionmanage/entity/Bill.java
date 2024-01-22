
package com.example.fashionmanage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "bill", schema = "fashionShop")
public class Bill {
    @Id
    @Size(max = 255)
    @Column(name ="id", nullable = false,unique = true)
    private String id;

    @NotNull
    @Column(name = "total", nullable = false)
    private Integer total;

    @NotNull
    @Column(name = "release_date", nullable = false)
    private Instant releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "discount_id", nullable = true)
    private Discount discount;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
