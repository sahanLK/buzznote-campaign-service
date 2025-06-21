package com.buzznote.campaign.service;

import com.buzznote.campaign.dto.ContactCreateRequest;
import com.buzznote.campaign.dto.ContactListCreateRequest;
import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;
import com.buzznote.campaign.repo.ContactListRepo;
import com.buzznote.campaign.repo.ContactRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ContactService {

    private ContactListRepo contactListRepo;
    private ContactRepo contactRepo;

    public ContactList createContactList(@Valid ContactListCreateRequest contactListCreateRequest) {
        ContactList contactList = new ContactList();
        contactList.setName(contactListCreateRequest.getName());
        return contactListRepo.save(contactList);
    }

    public List<ContactList> getContactList() {
        return contactListRepo.findAll();
    }

    public ContactList getContactListDetails(UUID contactListId) {
        return contactListRepo.findById(contactListId).orElseThrow();
    }

    @Transactional
    public Contact createContact(@Valid ContactCreateRequest contactCreateRequest) {
        Contact contact = new Contact();
        contact.setAddress(contactCreateRequest.getAddress());

        for (UUID contactListId : contactCreateRequest.getContactLists()) {
            ContactList contactList = contactListRepo.findById(contactListId)
                    .orElseThrow(() -> new RuntimeException("List not found"));
            contact.getContactLists().add(contactList);
            contactList.getContacts().add(contact);
        }
        return contactRepo.save(contact);
    }

    public Contact getContactDetails(UUID contactId) {
        return contactRepo.findById(contactId).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

}
