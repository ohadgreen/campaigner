package com.mabaya.campaigner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product extends BaseEntity {
    private Integer serialNumber;
    private String title;
    private Category category;
    private double price;
    private Integer sellerId;

    public Product(Integer id, Integer serialNumber, String title, Category category, double price, Integer sellerId) {
        super(id);
        this.serialNumber = serialNumber;
        this.title = title;
        this.category = category;
        this.price = price;
        this.sellerId = sellerId;
    }
}
