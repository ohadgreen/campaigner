package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;

public interface ProductService {

    Product findById(Integer id);

    Product save(Product product);

}
