package com.buzznote.campaign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class ContactListCreateResponse {
    private UUID id;
    private String name;
}
