package com.buzznote.campaign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class CampaignDto {
    private UUID id;
    private String title;
    private String senderName;
    private String senderEmail;
    private String body;
}
