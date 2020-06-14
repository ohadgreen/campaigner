package com.mabaya.campaigner.services.category;

import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CategoryMapService extends GeneralMapService<Category, Integer> implements CategoryService {
    @Override
    public Category findById(Integer id, Map categoryMap) {
        return super.findById(id, categoryMap);
    }

    @Override
    public Category save(Category category, Map<Integer, Category> categoryMap) {
        return super.save(category, categoryMap);
    }
}
