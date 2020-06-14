package com.mabaya.campaigner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {
    private Integer serialNumber;
    private String title;
    private Category category;
    private double price;
    private Integer sellerId;

}
