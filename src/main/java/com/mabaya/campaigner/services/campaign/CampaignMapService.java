package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CampaignMapService extends GeneralMapService<Campaign, Integer> implements CampaignService {
    @Override
    public Campaign findById(Integer id, Map campaignMap) {
        return super.findById(id, campaignMap);
    }

    @Override
    public Campaign save(Campaign campaign, Map<Integer, Campaign> campaignMap, Map<Integer, Set<Integer>> sellerProductIndex, Map<Integer, Set<Integer>> productCampaignIndex) {
        Campaign savedCampaign = super.save(campaign, campaignMap);

        Integer sellerId = campaign.getSellerId();
        if (sellerId != null) {
            if (sellerProductIndex.keySet().contains(sellerId)) {
                Set<Integer> sellerProductIdSet = sellerProductIndex.get(sellerId);

                for (Integer productId : sellerProductIdSet) {
                    if (productCampaignIndex.keySet().contains(productId)) {
                        productCampaignIndex.get(productId).add(savedCampaign.getId());
                    }
                    else {
                        Set<Integer> newCampaignIdSet = new HashSet<>();
                        newCampaignIdSet.add(savedCampaign.getId());
                        productCampaignIndex.put(productId, newCampaignIdSet);
                    }
                }
            }
        }

        return savedCampaign;
    }
}
