package com.mabaya.campaigner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category extends BaseEntity{
    private String title;

    @Builder
    public Category(Integer id, String title) {
        super(id);
        this.title = title;
    }
}
