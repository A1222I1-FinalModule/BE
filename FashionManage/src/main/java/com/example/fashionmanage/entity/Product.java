
package com.example.fashionmanage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product", schema = "fashionShop")
public class Product {
    @Id
    @Size(max = 255)
    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @NotNull
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @NotNull
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id", nullable = false)
    private com.example.fashionmanage.entity.Size size;



}

