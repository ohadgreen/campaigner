package com.mabaya.campaigner.controllers;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.services.campaign.CampaignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping("/create")
    public ResponseEntity<Campaign> saveNewCampaign(@RequestBody Campaign campaign) {
        Campaign savedCampaign = campaignService.save(campaign);
        if (savedCampaign != null) {
            return new ResponseEntity<>(savedCampaign, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        // TODO: create campaign dto with list of products
    }
}
