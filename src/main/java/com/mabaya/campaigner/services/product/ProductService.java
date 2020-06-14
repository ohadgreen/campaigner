package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;

import java.util.Map;

public interface ProductService {

    Product findById(Integer id, Map<Integer, Product> productMap);

    Product save(Product product, Map<Integer, Product> productMap);

}
