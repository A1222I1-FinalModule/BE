
package com.example.fashionmanage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonBackReference
    @OneToMany(mappedBy = "type")
    private Set<Customer> customers = new LinkedHashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private Set<Discount> discounts = new LinkedHashSet<>();

}
