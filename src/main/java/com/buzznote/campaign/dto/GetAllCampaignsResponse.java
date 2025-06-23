package com.buzznote.campaign.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GetAllCampaignsResponse {
    private Set<CampaignListResponse> data;
    private Boolean more;
}
