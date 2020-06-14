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

    @Builder
    public Seller(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Builder
    public Seller(String name) {
        this.name = name;
    }
}
