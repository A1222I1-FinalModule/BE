
package com.example.fashionmanage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer_type", schema = "fashionShop")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "type")
    private Set<Customer> customers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customerType")
    private Set<Discount> discounts = new LinkedHashSet<>();

}
