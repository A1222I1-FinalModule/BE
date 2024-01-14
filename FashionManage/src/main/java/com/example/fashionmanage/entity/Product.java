
package com.example.fashionmanage.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @Column(name= "image")
    private String image;

    @Column(name = "price")
    private Double price;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private com.example.fashionmanage.entity.Size size;


//    @OneToMany(mappedBy = "productCode")
//    private Set<ProductSize> productSizes = new LinkedHashSet<>();

}

