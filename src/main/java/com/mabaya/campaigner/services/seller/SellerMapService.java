package com.mabaya.campaigner.services.seller;

import com.mabaya.campaigner.model.Seller;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class SellerMapService extends GeneralMapService<Seller, Integer> implements SellerService {
    @Override
    public Seller findById(Integer id, Map sellerMap) {
        return super.findById(id, sellerMap);
    }

    @Override
    public Seller save(Seller seller, Map<Integer, Seller> sellerMap) {
        return super.save(seller, sellerMap);
    }
}
