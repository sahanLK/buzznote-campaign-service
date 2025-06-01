package com.buzznote.campaign.service;

import com.buzznote.campaign.model.Campaign;
import com.buzznote.campaign.dto.CampaignCreateRequest;
import com.buzznote.campaign.repo.CampaignRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CampaignService {

    private final CampaignRepo campaignRepo;

    public Campaign createCampaign(CampaignCreateRequest campaign) {
        Campaign newCampaign = new Campaign();
        newCampaign.setTitle(campaign.getTitle());
        newCampaign.setSenderEmail(campaign.getSenderEmail());
        newCampaign.setSenderName(campaign.getSenderName());
        newCampaign.setBody(campaign.getBody());
        return campaignRepo.save(newCampaign);
    }
}
