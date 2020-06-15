package com.mabaya.campaigner.model.dto;

import com.mabaya.campaigner.model.CampaignStatus;
import com.mabaya.campaigner.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class CampaignDto {
    private Integer id;
    private String name;
    private CampaignStatus campaignStatus;
    private Integer sellerId;
    private double bid;
    private Set<Product> products;

    @Builder
    public CampaignDto(Integer id, String name, CampaignStatus campaignStatus, Integer sellerId, double bid, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.campaignStatus = campaignStatus;
        this.sellerId = sellerId;
        this.bid = bid;
        this.products = products;
    }
}
