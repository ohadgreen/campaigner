package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.category.CategoryMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapServiceTest {

    private DataStructures dataStructuresTest = new DataStructures();
    private ProductMapService productMapService;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {

        productMapService = new ProductMapService(dataStructuresTest);
        product1 = Product.builder()
                .serialNumber(1000)
                .categoryId(1)
                .sellerId(1)
                .title("Air Jordan")
                .price(100.0)
                .build();

        product2 = Product.builder()
                .serialNumber(2000)
                .categoryId(1)
                .sellerId(2)
                .title("All Stars")
                .price(99.90)
                .build();
    }

    @Test
    void save() {
        Product savedJordan = productMapService.save(product1);
        Product savedAllStars = productMapService.save(product2);

        assertEquals(2, dataStructuresTest.productMap.size());
        assertEquals(2, savedAllStars.getId());
        assertEquals(2, dataStructuresTest.categoryProductIndex.get(1).size());
        assertEquals(2, dataStructuresTest.sellerProductIndex.size());
        assertEquals(1, dataStructuresTest.sellerProductIndex.get(1).size());
    }

    @Test
    void getByIdTest() {
        productMapService.save(product1);
        Product savedProduct = productMapService.findById(1);
        assertEquals(product1.getTitle(), savedProduct.getTitle());
    }
}