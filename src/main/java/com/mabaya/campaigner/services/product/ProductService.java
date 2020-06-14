package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;

import java.util.Map;
import java.util.Set;

public interface ProductService {

    Product findById(Integer id, Map<Integer, Product> productMap);

    Product save(Product product, Map<Integer, Product> productMap, Map<Integer, Set<Integer>> categoryProductIndex, Map<Integer, Set<Integer>> sellerProductIndex);

}
