package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;

import java.util.Map;

public interface CampaignService {

    Campaign findById(Integer id, Map<Integer, Campaign> campaignMap);

    Campaign save(Campaign campaign, Map<Integer, Campaign> campaignMap);
}
