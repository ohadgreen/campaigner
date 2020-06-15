package com.mabaya.campaigner.controllers;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.dto.CampaignDto;
import com.mabaya.campaigner.services.campaign.CampaignService;
import com.mabaya.campaigner.services.campaign.ConvertCampaignToDto;
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
    private final ConvertCampaignToDto convertCampaignToDto;

    public CampaignController(CampaignService campaignService, ConvertCampaignToDto convertCampaignToDto) {
        this.campaignService = campaignService;
        this.convertCampaignToDto = convertCampaignToDto;
    }

    @PostMapping("/create")
    public ResponseEntity<CampaignDto> saveNewCampaign(@RequestBody Campaign campaign) {
        Campaign savedCampaign = campaignService.save(campaign);
        if (savedCampaign != null) {
            CampaignDto campaignDto = convertCampaignToDto.convert(savedCampaign);
            return new ResponseEntity<>(campaignDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
