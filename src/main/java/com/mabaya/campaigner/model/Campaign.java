package com.mabaya.campaigner.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Campaign extends BaseEntity{
    private String name;
    private CampaignStatus campaignStatus;
    private Integer sellerId;
    private double bid;

    @Builder
    public Campaign(Integer id, String name, CampaignStatus campaignStatus, Integer sellerId, double bid) {
        super(id);
        this.name = name;
        this.campaignStatus = campaignStatus;
        this.sellerId = sellerId;
        this.bid = bid;
    }

    @Builder
    public Campaign(String name, CampaignStatus campaignStatus, Integer sellerId, double bid) {
        this.name = name;
        this.campaignStatus = campaignStatus;
        this.sellerId = sellerId;
        this.bid = bid;
    }
}
