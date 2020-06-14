package com.mabaya.campaigner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    private Integer id;
    private String name;
    private CampaignStatus campaignStatus;
    private Integer sellerId;
    private double bid;

}
