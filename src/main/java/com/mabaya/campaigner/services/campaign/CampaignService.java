package com.mabaya.campaigner.services.campaign;

import com.mabaya.campaigner.model.Campaign;

import java.util.Map;
import java.util.Set;

public interface CampaignService {

    Campaign findById(Integer id);

    Campaign save(Campaign campaign);
}
