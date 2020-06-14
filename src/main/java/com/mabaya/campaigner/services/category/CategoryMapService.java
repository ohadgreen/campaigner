package com.mabaya.campaigner.services.category;

import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CategoryMapService extends GeneralMapService<Category, Integer> implements CategoryService {

    private DataStructures dataStructures;

    public CategoryMapService(DataStructures dataStructures) {
        this.dataStructures = dataStructures;
    }

    @Override
    public Category findById(Integer id) {
        return super.findById(id, dataStructures.categoryMap);
    }

    @Override
    public Category save(Category category) {
        return super.save(category, dataStructures.categoryMap);
    }
}
