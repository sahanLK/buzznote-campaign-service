package com.buzznote.campaign.mappers;

import com.buzznote.campaign.dto.*;
import com.buzznote.campaign.model.Campaign;
import com.buzznote.campaign.model.ContactList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CampaignResponseMapper {

    public CampaignCreateResponse campaignCreateResponse(Campaign campaign) {
        Set<ContactListCreateResponse> contactLists = campaign.getContactLists()
                .stream()
                .map(c -> new ContactListCreateResponse(c.getId(), c.getName()))
                .collect(Collectors.toSet());

        CampaignCreateResponse response = new CampaignCreateResponse();
        response.setId(campaign.getId());
        response.setTitle(campaign.getTitle());
        response.setSenderName(campaign.getSenderName());
        response.setSenderEmail(campaign.getSenderEmail());
        response.setBody(campaign.getBody());
        response.setContactLists(contactLists);
        return response;
    }

    public GetAllCampaignsResponse campaignListResponse(List<Campaign> campaigns) {
        Set<CampaignDto> campaignList = campaigns
                .stream()
                .map(c -> new CampaignDto(c.getId(), c.getTitle(), c.getSenderName(), c.getSenderEmail(), c.getBody()))
                .collect(Collectors.toSet());

        GetAllCampaignsResponse response = new GetAllCampaignsResponse();
        response.setCampaigns(campaignList);
        return response;
    }
}
