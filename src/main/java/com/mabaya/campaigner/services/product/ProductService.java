package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;

import java.util.Map;
import java.util.Set;

public interface ProductService {

    Product findById(Integer id);

    Product save(Product product);

}
