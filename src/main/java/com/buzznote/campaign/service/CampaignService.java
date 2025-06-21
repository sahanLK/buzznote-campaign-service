package com.buzznote.campaign.service;

import com.buzznote.campaign.exception.DuplicateResourceException;
import com.buzznote.campaign.model.Campaign;
import com.buzznote.campaign.dto.CampaignCreateRequest;
import com.buzznote.campaign.model.ContactList;
import com.buzznote.campaign.repo.CampaignRepo;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CampaignService {

    private final CampaignRepo campaignRepo;
    private final ContactService contactService;

    public Campaign createCampaign(CampaignCreateRequest campaign) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();
        Campaign newCampaign = new Campaign();

        for (UUID contactListId: campaign.getContactListIds()) {
            ContactList contactList = contactService.findContactList(contactListId);
            newCampaign.getContactLists().add(contactList);
            contactList.getCampaigns().add(newCampaign);
        }

        newCampaign.setUserId(userId);
        newCampaign.setTitle(campaign.getTitle());
        newCampaign.setSenderEmail(campaign.getSenderEmail());
        newCampaign.setSenderName(campaign.getSenderName());
        newCampaign.setBody(campaign.getBody());

        try {
            return campaignRepo.save(newCampaign);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateResourceException("campaign already exists: " + campaign.getTitle());
        }
    }

    public List<Campaign> getCampaignList(String userId) {
        return campaignRepo.findAll();
    }
}
