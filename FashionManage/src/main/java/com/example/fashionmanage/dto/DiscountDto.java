package com.example.fashionmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Size(min = 2, max = 50)
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
    @Min(value = 20000)
    @Max(value = 1000000)
    private double sale;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date beginDate;

    private boolean isDelete;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    private CustomerTypeDto customerType;

}
