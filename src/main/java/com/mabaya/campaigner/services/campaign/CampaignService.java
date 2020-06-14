package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;

import java.util.Map;
import java.util.Set;

public interface CampaignService {

    Campaign findById(Integer id, Map<Integer, Campaign> campaignMap);

    Campaign save(Campaign campaign, Map<Integer, Campaign> campaignMap, Map<Integer, Set<Integer>> sellerProductIndex, Map<Integer, Set<Integer>> productCampaignIndex);
}
