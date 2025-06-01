package com.buzznote.campaign.controller;

import com.buzznote.campaign.model.Campaign;
import com.buzznote.campaign.dto.CampaignCreateRequest;
import com.buzznote.campaign.service.CampaignService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/campaign")
@RestController
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping("/create")
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody CampaignCreateRequest campaign) {
        Campaign saved = campaignService.createCampaign(campaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
