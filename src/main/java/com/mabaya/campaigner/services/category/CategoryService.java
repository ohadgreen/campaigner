package com.mabaya.campaigner.services.category;

import com.mabaya.campaigner.model.Category;

import java.util.Map;

public interface CategoryService {
    Category findById(Integer id);

    Category save(Category category);
}
