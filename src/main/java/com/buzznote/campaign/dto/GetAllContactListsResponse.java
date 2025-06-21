package com.buzznote.campaign.dto;

import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;
import lombok.Data;

import java.util.Set;

@Data
public class GetAllContactListsResponse {
    private Set<ContactList> contactLists;
}
