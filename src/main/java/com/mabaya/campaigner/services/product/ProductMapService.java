package com.mabaya.campaigner.services.product;

import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ProductMapService extends GeneralMapService<Product, Integer> implements ProductService {
    @Override
    public Product findById(Integer id, Map productMap) {
        return super.findById(id, productMap);
    }

    @Override
    public Product save(Product product, Map<Integer, Product> productMap, Map<Integer, Set<Integer>> categoryProductIndex, Map<Integer, Set<Integer>> sellerProductIndex) {

        Product savedProduct = super.save(product, productMap);

        Integer categoryId = product.getCategoryId();
        if (categoryId != null) {
            if (categoryProductIndex.keySet().contains(categoryId)) { // add this product to existing category
                categoryProductIndex.get(categoryId).add(savedProduct.getId());
            }
            else { // create a new category index
                Set<Integer> productSet = new HashSet<>();
                productSet.add(savedProduct.getId());
                categoryProductIndex.put(categoryId, productSet);
            }
        }

        Integer sellerId = product.getSellerId();
        if (sellerId != null) {
            if (sellerProductIndex.keySet().contains(sellerId)) { // add this product to existing seller
                sellerProductIndex.get(categoryId).add(savedProduct.getId());
            }
            else { // create a new seller index
                Set<Integer> productSet = new HashSet<>();
                productSet.add(savedProduct.getId());
                sellerProductIndex.put(sellerId, productSet);
            }
        }

        return savedProduct;
    }
}
