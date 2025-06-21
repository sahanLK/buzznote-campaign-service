package com.buzznote.campaign.service;

import com.buzznote.campaign.dto.ContactCreateRequest;
import com.buzznote.campaign.dto.ContactListCreateRequest;
import com.buzznote.campaign.exception.DuplicateResourceException;
import com.buzznote.campaign.exception.NotFoundException;
import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;
import com.buzznote.campaign.repo.ContactListRepo;
import com.buzznote.campaign.repo.ContactRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<ContactList> getContactLists() {
        return contactListRepo.findAll();
    }

    public ContactList findContactList(UUID contactListId) {
        return contactListRepo.findById(contactListId)
                .orElseThrow(() -> new NotFoundException("no contact list with id: " + contactListId));
    }

    public ContactList getContactListDetails(UUID contactListId) {
        return contactListRepo.findById(contactListId).orElseThrow(NotFoundException::new);
    }

    public Contact createContact(@Valid ContactCreateRequest contactCreateRequest) {
        Contact contact = new Contact();
        contact.setAddress(contactCreateRequest.getAddress());

        for (UUID contactListId : contactCreateRequest.getContactLists()) {
            ContactList contactList = contactListRepo.findById(contactListId)
                    .orElseThrow(() -> new NotFoundException("contact list not found: " + contactListId));
            contact.getContactLists().add(contactList);
            contactList.getContacts().add(contact);
        }

        try {
            Contact response = contactRepo.save(contact);
            return contactRepo.save(response);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateResourceException("Contact " + contact.getAddress() + " already exists");
        }

    }

    public Contact getContactDetails(UUID contactId) {
        return contactRepo.findById(contactId).orElseThrow(() -> new NotFoundException("Contact not found"));
    }

}
