package com.buzznote.campaign.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class ContactListDetailsResponse {
    private UUID id;
    private String name;
    private Set<ContactCreateResponse> contacts;
}
