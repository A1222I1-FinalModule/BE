package com.example.fashionmanage.validation;

import com.example.fashionmanage.entity.Customer;
import com.example.fashionmanage.entity.Discount;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
public class CustomerTypeDto {
    private Integer id;

    @Size(max = 255)
    private String typeName;

}
