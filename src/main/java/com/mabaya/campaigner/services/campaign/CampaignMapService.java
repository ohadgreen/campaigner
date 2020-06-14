package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.CampaignStatus;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CampaignMapService extends GeneralMapService<Campaign, Integer> implements CampaignService {
    private DataStructures dataStructures;

    public CampaignMapService(DataStructures dataStructures) {
        this.dataStructures = dataStructures;
    }

    @Override
    public Campaign findById(Integer id) {
        return super.findById(id, dataStructures.campaignMap);
    }

    @Override
    public Campaign save(Campaign campaign) {
        campaign.setCampaignStatus(CampaignStatus.ACTIVE);
        Campaign savedCampaign = super.save(campaign, dataStructures.campaignMap);

        Integer sellerId = campaign.getSellerId();
        if (sellerId != null) {
            if (dataStructures.sellerProductIndex.keySet().contains(sellerId)) {
                Set<Integer> sellerProductIdSet = dataStructures.sellerProductIndex.get(sellerId);

                for (Integer productId : sellerProductIdSet) {
                    if (dataStructures.productCampaignIndex.keySet().contains(productId)) {
                        dataStructures.productCampaignIndex.get(productId).add(savedCampaign.getId());
                    }
                    else {
                        Set<Integer> newCampaignIdSet = new HashSet<>();
                        newCampaignIdSet.add(savedCampaign.getId());
                        dataStructures.productCampaignIndex.put(productId, newCampaignIdSet);
                    }
                }
            }
        }

        return savedCampaign;
    }
}
