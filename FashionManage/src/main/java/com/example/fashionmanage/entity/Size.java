
package com.example.fashionmanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "size", schema = "fashionShop")
public class Size {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 255)
    @NotNull
    @Column(name = "size", nullable = false)
    private String size;

    @OneToMany(mappedBy = "size")
    private Set<Product> products = new LinkedHashSet<>();

}

