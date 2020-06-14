package com.mabaya.campaigner.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Seller extends BaseEntity {
    private String name;
    private Set<Product> products = new HashSet<>();

    @Builder
    public Seller(Integer id, String name, Set<Product> products) {
        super(id);
        this.name = name;
        this.products = products;
    }

    @Builder
    public Seller(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }
}
