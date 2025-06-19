package com.buzznote.campaign.controller;

import com.buzznote.campaign.dto.ContactCreateRequest;
import com.buzznote.campaign.dto.ContactListCreateRequest;
import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;
import com.buzznote.campaign.service.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/contacts")
@RestController
public class ContactController {

    private ContactService contactService;

    @PostMapping("/list")
    public ResponseEntity<ContactList> createContactList(@Valid @RequestBody ContactListCreateRequest contactListCreateRequest) {
        ContactList contactList = contactService.createContactList(contactListCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactList);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllContactLists() {
        List<ContactList> contactListSet = contactService.getContactList();
        return ResponseEntity.ok().body(contactListSet);
    }

    @GetMapping("/list/details")
    public ResponseEntity<?> getContactListDetails(@RequestParam UUID contactListId) {
        ContactList contactList = contactService.getContactListDetails(contactListId);
        System.out.println("CONTACTS: " + contactList.getContacts());
        return ResponseEntity.ok().body(contactList);
    }

    @PostMapping("")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody ContactCreateRequest contactCreateRequest) {
        System.out.println("In Create Contact");
        Contact contact = contactService.createContact(contactCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @GetMapping("")
    public ResponseEntity<?> getContactDetails(@RequestParam UUID contactId) {
        System.out.println("In Contact Details");
        Optional<Contact> contact = contactService.getContactDetails(contactId);
        System.out.println("Received: " + contact);
        System.out.println(contact.getClass());
        return ResponseEntity.ok().body(contact);
    }

}
