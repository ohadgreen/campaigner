package com.mabaya.campaigner.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category extends BaseEntity{
    private String title;

    @Builder
    public Category(Integer id, String title) {
        super(id);
        this.title = title;
    }

    @Builder
    public Category(String title) {
        this.title = title;
    }
}
