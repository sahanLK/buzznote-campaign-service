package com.buzznote.campaign.mappers;

import com.buzznote.campaign.dto.ContactCreateResponse;
import com.buzznote.campaign.dto.ContactDetailsResponse;
import com.buzznote.campaign.dto.ContactListCreateResponse;
import com.buzznote.campaign.dto.ContactListDetailsResponse;
import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;

import java.util.Set;
import java.util.stream.Collectors;

public class ContactResponseMapper {

    public static ContactCreateResponse contactCreateResponse(Contact contact) {
        Set<ContactListCreateResponse> contactLists = contact.getContactLists()
                .stream()
                .map(cl -> new ContactListCreateResponse(cl.getName()))
                .collect(Collectors.toSet());
        ContactCreateResponse response = new ContactCreateResponse();
        response.setId(contact.getId());
        response.setAddress(contact.getAddress());
        response.setContactList(contactLists);
        return response;
    }

    public static ContactDetailsResponse contactDetailsResponse(Contact contact) {
        Set<ContactListCreateResponse> contactLists = contact.getContactLists()
                .stream()
                .map(cl -> new ContactListCreateResponse(cl.getName()))
                .collect(Collectors.toSet());
        ContactDetailsResponse response = new ContactDetailsResponse();
        response.setId(contact.getId());
        response.setAddress(contact.getAddress());
        response.setContactList(contactLists);
        return response;
    }

    public static ContactListDetailsResponse contactListDetailsResponse(ContactList contactList) {
        Set<ContactCreateResponse> contactLists = contactList.getContacts()
                .stream()
                .map(c -> new ContactCreateResponse(c.getId(), c.getAddress()))
                .collect(Collectors.toSet());

        ContactListDetailsResponse response = new ContactListDetailsResponse();
        response.setId(contactList.getId());
        response.setName(contactList.getName());
        response.setContacts(contactLists);
        return response;
    }
}
