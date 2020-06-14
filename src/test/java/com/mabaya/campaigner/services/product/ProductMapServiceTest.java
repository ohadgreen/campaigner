package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.services.category.CategoryMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapServiceTest {

    private Map productMap = new HashMap<>();
    private Map<Integer, Set<Integer>> categoryProductIndex = new HashMap<>();
    private Map<Integer, Set<Integer>> sellerProductIndex = new HashMap<>();
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
        Product savedJordan = productMapService.save(product1, productMap, categoryProductIndex, sellerProductIndex);
        Product savedAllStars = productMapService.save(product2, productMap, categoryProductIndex, sellerProductIndex);

        assertEquals(2, productMap.size());
        assertEquals(2, savedAllStars.getId());
        assertEquals(2, categoryProductIndex.get(1).size());
        assertEquals(2, sellerProductIndex.size());
        assertEquals(1, sellerProductIndex.get(1).size());
    }

    @Test
    void getByIdTest() {
        productMapService.save(product1, productMap, categoryProductIndex, sellerProductIndex);
        Product savedProduct = productMapService.findById(1, productMap);
        assertEquals(product1.getTitle(), savedProduct.getTitle());
    }
}