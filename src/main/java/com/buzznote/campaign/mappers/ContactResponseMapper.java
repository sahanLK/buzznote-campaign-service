package com.buzznote.campaign.mappers;

import com.buzznote.campaign.dto.*;
import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ContactResponseMapper {

    public ContactCreateResponse contactCreateResponse(Contact contact) {
        Set<ContactListCreateResponse> contactLists = contact.getContactLists()
                .stream()
                .map(cl -> new ContactListCreateResponse(cl.getId(), cl.getName()))
                .collect(Collectors.toSet());
        ContactCreateResponse response = new ContactCreateResponse();
        response.setId(contact.getId());
        response.setAddress(contact.getAddress());
        response.setContactList(contactLists);
        return response;
    }

    public ContactDetailsResponse contactDetailsResponse(Contact contact) {
        Set<ContactListCreateResponse> contactLists = contact.getContactLists()
                .stream()
                .map(cl -> new ContactListCreateResponse(cl.getId(), cl.getName()))
                .collect(Collectors.toSet());
        ContactDetailsResponse response = new ContactDetailsResponse();
        response.setId(contact.getId());
        response.setAddress(contact.getAddress());
        response.setContactList(contactLists);
        return response;
    }

    public ContactListDetailsResponse contactListDetailsResponse(ContactList contactList) {
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

    public GetAllContactListsResponse allContactLists(Page<ContactList> contactListSet) {
        Set<ContactListCreateResponse> contactLists = contactListSet
                .stream()
                .map(c -> new ContactListCreateResponse(c.getId(), c.getName()))
                .collect(Collectors.toSet());

        GetAllContactListsResponse response = new GetAllContactListsResponse();
        response.setData(contactLists);
        response.setMore(contactListSet.hasNext());
        return response;
    }
}
