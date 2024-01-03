package com.example.fashionmanage.entity;

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
}
