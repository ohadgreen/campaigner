package com.mabaya.campaigner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Integer id;
    private String name;
    private Set<Product> products = new HashSet<>();
}
