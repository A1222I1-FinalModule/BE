
package com.example.fashionmanage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "discount", schema = "fashionShop")
public class Discount {
    @Id
    @Size(max = 255)
    @Column(name = "discount_code", nullable = false)
    private String discountCode;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "reward_point")
    private Integer rewardPoint;

    @Lob
    @Column(name = "`condition`")
    private String condition;

    @NotNull
    @Column(name = "begin_date", nullable = false)
    private Instant beginDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;


}
