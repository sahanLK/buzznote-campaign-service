package com.buzznote.campaign.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GetAllContactListsResponse {
    private Set<ContactListCreateResponse> contactLists;
}
