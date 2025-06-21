package com.buzznote.campaign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactCreateResponse {
    private UUID id;
    private String address;
    private Set<ContactListCreateResponse> contactList;

    public ContactCreateResponse(UUID id, String address) {
        this.id = id;
        this.address = address;
    }
}
