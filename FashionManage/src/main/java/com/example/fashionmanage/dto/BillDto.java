package com.example.fashionmanage.dto;

import com.example.fashionmanage.dto.ProductBill;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BillDto {
    private List<ProductBill> productBills;
    private String customerCode;
    private String employeeCode;
    private String discountCode;
    private String billCode;
    private Integer total;
}
