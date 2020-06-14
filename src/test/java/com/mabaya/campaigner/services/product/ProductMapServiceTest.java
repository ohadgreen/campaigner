package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.services.category.CategoryMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapServiceTest {

    private Map productMap = new HashMap<>();
    private ProductMapService productMapService = new ProductMapService();
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
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
        Product savedJordan = productMapService.save(product1, productMap);
        Product savedAllStars = productMapService.save(product2, productMap);

        assertEquals(2, productMap.size());
        assertEquals(2, savedAllStars.getId());
    }

    @Test
    void getByIdTest() {
        productMapService.save(product1, productMap);
        Product savedProduct = productMapService.findById(1, productMap);
        assertEquals(product1.getTitle(), savedProduct.getTitle());
    }
}