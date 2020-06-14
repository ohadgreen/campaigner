package com.mabaya.campaigner.services.category;

import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.product.ProductMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapServiceTest {

    private DataStructures dataStructuresTest = new DataStructures();
    private CategoryMapService categoryMapService;

    @BeforeEach
    void setUp() {
        categoryMapService = new CategoryMapService(dataStructuresTest);
    }

    @Test
    public void saveCategoryTest() {
        Category hats = Category.builder().title("Hats").build();
        Category shirts = Category.builder().title("Shirts").build();

        Category savedCategory1 = categoryMapService.save(hats);
        Category savedCategory2 = categoryMapService.save(shirts);

        assertEquals(2, dataStructuresTest.categoryMap.size());
        assertEquals(1, savedCategory1.getId());
        assertEquals(2, savedCategory2.getId());
    }

}