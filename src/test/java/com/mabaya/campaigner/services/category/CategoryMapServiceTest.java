package com.mabaya.campaigner.services.category;

import com.mabaya.campaigner.model.Category;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapServiceTest {

    private Map categoryMap = new HashMap<>();
    private CategoryMapService categoryMapService = new CategoryMapService();

    @Test
    public void saveCategoryTest() {
        Category hats = Category.builder().title("Hats").build();
        Category shirts = Category.builder().title("Shirts").build();

        Category savedCategory1 = categoryMapService.save(hats, categoryMap);
        Category savedCategory2 = categoryMapService.save(shirts, categoryMap);

        assertEquals(2, categoryMap.size());
        assertEquals(1, savedCategory1.getId());
        assertEquals(2, savedCategory2.getId());
    }

}