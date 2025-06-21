package com.buzznote.campaign.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CampaignCreateRequest {

    @NotBlank(message = "Title is required")
    @Size(message = "Title should contain at least 5 characters", min = 5, max = 200)
    private String title;
    private String senderName;

    @Email(message = "Please enter a valid email")
    private String senderEmail;

    @NotBlank(message = "Body is required")
    private String body;
    private Set<UUID> contactListIds;
}
