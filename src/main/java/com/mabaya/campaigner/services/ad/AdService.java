package com.mabaya.campaigner.services.ad;

import com.mabaya.campaigner.model.Product;

public interface AdService {
    Product findHighestBidProductByCategory(String category);
}
