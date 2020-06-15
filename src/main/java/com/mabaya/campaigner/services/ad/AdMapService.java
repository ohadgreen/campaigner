package com.mabaya.campaigner.services.ad;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.CampaignStatus;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.persist.DataStructures;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
@Service
public class AdMapService implements AdService{

    private DataStructures dataStructures;

    public AdMapService(DataStructures dataStructures) {
        this.dataStructures = dataStructures;
    }

    @Override
    public Product findHighestBidProductByCategory(String category) {
        Integer categoryId = dataStructures.categoryNameIdMap.get(category);
        Product highestBidProduct = null;

        if (categoryId != null) {
            Set<Integer> allCategoryProductIds = dataStructures.categoryProductIndex.get(categoryId);
            if (allCategoryProductIds.size() > 0) {
                double highestBid = 0;
                for (Integer productId : allCategoryProductIds) {
                    if (dataStructures.productCampaignIndex.keySet().contains(productId)) {
                        Set<Integer> productCampaignIdSet = dataStructures.productCampaignIndex.get(productId);
                        if (productCampaignIdSet.size() > 0) {
                            for (Integer campaignId : productCampaignIdSet) {
                                Campaign campaign = dataStructures.campaignMap.get(campaignId);
                                if (campaign.getCampaignStatus() == CampaignStatus.ACTIVE && campaign.getBid() > highestBid) {
                                    highestBid = campaign.getBid();
                                    highestBidProduct =  dataStructures.productMap.get(productId);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (highestBidProduct == null) {
            if (dataStructures.campaignOrderedByBidMap.size() > 0) {
                Campaign highestBidCampaign = dataStructures.campaignOrderedByBidMap.firstEntry().getValue();
                Integer highestBidSellerId = highestBidCampaign.getSellerId();
                if (highestBidSellerId != null) {
                    Set<Integer> highestBidProducts = dataStructures.sellerProductIndex.get(highestBidSellerId);
                    if (highestBidProducts.size() > 0) {
                        Integer highestBidProdId = highestBidProducts.iterator().next();
                        highestBidProduct = dataStructures.productMap.get(highestBidProdId);

                    }
                }
            }

        }

        return highestBidProduct;
    }
}
