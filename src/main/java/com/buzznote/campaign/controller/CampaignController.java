package com.buzznote.campaign.controller;

import com.buzznote.campaign.dto.CampaignCreateRequest;
import com.buzznote.campaign.mappers.CampaignResponseMapper;
import com.buzznote.campaign.model.Campaign;
import com.buzznote.campaign.service.CampaignService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@AllArgsConstructor
@RequestMapping("/campaigns")
@RestController
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    private final CampaignResponseMapper mapper;

    @PostMapping("")
    public ResponseEntity<?> createCampaign(@Valid @RequestBody CampaignCreateRequest campaign) {
        Campaign saved = campaignService.createCampaign(campaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.campaignCreateResponse(saved));
    }

    @GetMapping("")
    public ResponseEntity<?> campaignList(Principal user, Pageable pageable) {
        Page<Campaign> campaigns = campaignService.getCampaignList(user.getName(), pageable);
        return ResponseEntity.ok().body(mapper.campaignListResponse(campaigns));
    }
}
