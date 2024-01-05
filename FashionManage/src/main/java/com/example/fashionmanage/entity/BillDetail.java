
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
@Table(name = "bill_detail", schema = "fashionShop")
public class BillDetail {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bill_id", nullable = false)
    @JsonManagedReference
    private Bill bill;
}
