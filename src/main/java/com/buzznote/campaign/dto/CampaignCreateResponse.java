package com.buzznote.campaign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignCreateResponse {
    private String title;
    private String senderName;
    private String senderEmail;
    private String body;
}
