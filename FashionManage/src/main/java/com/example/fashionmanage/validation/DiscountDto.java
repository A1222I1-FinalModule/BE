package com.example.fashionmanage.validation;

import com.example.fashionmanage.entity.CustomerType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.parameters.P;

import java.util.Date;

@Setter
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {
    @NotNull
    @Pattern(regexp = "^C[a-zA-Z0-9]{2,9}$")
    private String discountCode;

    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 /]{2,29}$")
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 1000)
    private Integer rewardPoint;

    @NotNull
    @Min(value = 1000)
    @Max(value = 100000000)
    private Integer condition;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date beginDate;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    private CustomerTypeDto customerType;

}
