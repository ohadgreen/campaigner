package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.services.GeneralMapService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CampaignMapService extends GeneralMapService<Campaign, Integer> implements CampaignService {
    @Override
    public Campaign findById(Integer id, Map campaignMap) {
        return super.findById(id, campaignMap);
    }

    @Override
    public Campaign save(Campaign campaign, Map<Integer, Campaign> campaignMap) {
        return super.save(campaign, campaignMap);
    }
}
