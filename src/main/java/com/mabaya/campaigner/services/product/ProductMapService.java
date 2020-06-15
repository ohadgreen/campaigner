package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ProductMapService extends GeneralMapService<Product, Integer> implements ProductService {

    private DataStructures dataStructures;

    public ProductMapService(DataStructures dataStructures) {
        this.dataStructures = dataStructures;
    }

    @Override
    public Product findById(Integer id) {
        return super.findById(id, dataStructures.productMap);
    }

    @Override
    public Product save(Product product) {

        Product savedProduct = super.save(product, dataStructures.productMap);

        Integer categoryId = product.getCategoryId();
        if (categoryId != null) {
            if (dataStructures.categoryProductIndex.keySet().contains(categoryId)) { // add this product to existing category
                dataStructures.categoryProductIndex.get(categoryId).add(savedProduct.getId());
            }
            else { // create a new category index
                Set<Integer> productSet = new HashSet<>();
                productSet.add(savedProduct.getId());
                dataStructures.categoryProductIndex.put(categoryId, productSet);
            }
        }

        Integer sellerId = product.getSellerId();
        if (sellerId != null) {
            if (dataStructures.sellerProductIndex.keySet().contains(sellerId)) { // add this product to existing seller
                dataStructures.sellerProductIndex.get(sellerId).add(savedProduct.getId());
            }
            else { // create a new seller index
                Set<Integer> productSet = new HashSet<>();
                productSet.add(savedProduct.getId());
                dataStructures.sellerProductIndex.put(sellerId, productSet);
            }
        }
        return savedProduct;
    }
}
