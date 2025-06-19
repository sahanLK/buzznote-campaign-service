package com.buzznote.campaign.controller;

import com.buzznote.campaign.model.Campaign;
import com.buzznote.campaign.dto.CampaignCreateRequest;
import com.buzznote.campaign.service.CampaignService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/campaigns")
@RestController
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping("")
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody CampaignCreateRequest campaign) {
        Campaign saved = campaignService.createCampaign(campaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("")
    public ResponseEntity<List<Campaign>> campaignList(Principal user) {
        List<Campaign> campaigns = campaignService.getCampaignList(user.getName());
        return ResponseEntity.ok().body(campaigns);
    }
}
