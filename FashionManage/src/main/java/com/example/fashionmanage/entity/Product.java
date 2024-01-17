
package com.example.fashionmanage.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @Size(max = 255,message = "Length from 5 to 255")
    @NotBlank(message = "Information cannot be left blank")
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity")
    @Min(value = 1,message = "Quantity must be 1 or more")
    private Integer quantity;

    @NotBlank(message = "Information cannot be left blank")
    @Column(name= "image")
    private String image;

    @Min(value = 1,message = "The lowest price must be from 1 VND")
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

