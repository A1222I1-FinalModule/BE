
package com.example.fashionmanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount", schema = "fashionShop")
public class Discount {
    @Id
    @Size(max = 10)
    @Column(name = "discount_code", nullable = false)
    private String discountCode;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "reward_point")
    private Integer rewardPoint;

    @Lob
    @Column(name = "`condition`")
    private Integer condition;


    @Lob
    @Column(name = "sale")
    private double sale;

    @NotNull
    @Column(name = "begin_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date beginDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    @Column(name = "is_delete", nullable = false)
    private boolean isDelete;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @Column(name = "number")
    private int number;
}
