package com.buzznote.campaign.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class ContactDetailsResponse {
    private UUID id;
    private String address;
    private Set<ContactListCreateResponse> contactList;
}
