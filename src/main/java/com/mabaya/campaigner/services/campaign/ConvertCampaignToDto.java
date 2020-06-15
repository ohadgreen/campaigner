package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.model.dto.CampaignDto;
import com.mabaya.campaigner.persist.DataStructures;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConvertCampaignToDto {

    private DataStructures dataStructures;

    public ConvertCampaignToDto(DataStructures dataStructures) {
        this.dataStructures = dataStructures;
    }

    public CampaignDto convert(Campaign campaign) {
        Set<Integer> productIds = dataStructures.sellerProductIndex.get(campaign.getSellerId());

        Set<Product> sellerProductSet = productIds.stream()
                .map(p -> dataStructures.productMap.get(p))
                .collect(Collectors.toSet());

        return CampaignDto.builder()
                .id(campaign.getId())
                .name(campaign.getName())
                .campaignStatus(campaign.getCampaignStatus())
                .sellerId(campaign.getSellerId())
                .bid(campaign.getBid())
                .products(sellerProductSet)
                .build();
    }
}
