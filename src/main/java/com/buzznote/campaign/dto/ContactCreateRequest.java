package com.buzznote.campaign.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class ContactCreateRequest {
    private String address;
    private Set<UUID> contactLists;
}
