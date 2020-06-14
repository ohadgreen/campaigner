package com.mabaya.campaigner.services.seller;

import com.mabaya.campaigner.model.Seller;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class SellerMapService extends GeneralMapService<Seller, Integer> implements SellerService {

    private DataStructures dataStructures;

    public SellerMapService(DataStructures dataStructures) {
        this.dataStructures = dataStructures;
    }

    @Override
    public Seller findById(Integer id) {
        return super.findById(id, dataStructures.sellerMap);
    }

    @Override
    public Seller save(Seller seller) {
        return super.save(seller, dataStructures.sellerMap);
    }
}
