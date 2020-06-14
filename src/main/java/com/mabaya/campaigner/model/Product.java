package com.mabaya.campaigner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Product extends BaseEntity {
    private Integer serialNumber;
    private String title;
    private Integer categoryId;
    private double price;
    private Integer sellerId;

    public Product(Integer id, Integer serialNumber, String title, Integer categoryId, double price, Integer sellerId) {
        super(id);
        this.serialNumber = serialNumber;
        this.title = title;
        this.categoryId = categoryId;
        this.price = price;
        this.sellerId = sellerId;
    }

    @Builder
    public Product(Integer serialNumber, String title, Integer categoryId, double price, Integer sellerId) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.categoryId = categoryId;
        this.price = price;
        this.sellerId = sellerId;
    }
}
