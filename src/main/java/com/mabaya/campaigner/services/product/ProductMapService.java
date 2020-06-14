package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductMapService extends GeneralMapService<Product, Integer> implements ProductService {
    @Override
    public Product findById(Integer id, Map productMap) {
        return super.findById(id, productMap);
    }

    @Override
    public Product save(Product product, Map<Integer, Product> productMap) {
        return super.save(product, productMap);
    }
}
