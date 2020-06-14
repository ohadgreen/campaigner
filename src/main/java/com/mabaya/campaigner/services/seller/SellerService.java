package com.mabaya.campaigner.services.seller;

import com.mabaya.campaigner.model.Seller;

import java.util.Map;

public interface SellerService {
    Seller findById(Integer id);

    Seller save(Seller seller);
}
