package com.buzznote.campaign.controller;

import com.buzznote.campaign.dto.ContactCreateRequest;
import com.buzznote.campaign.dto.ContactListCreateRequest;
import com.buzznote.campaign.mappers.ContactResponseMapper;
import com.buzznote.campaign.model.Contact;
import com.buzznote.campaign.model.ContactList;
import com.buzznote.campaign.service.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/contacts")
@RestController
public class ContactController {

    private ContactService contactService;
    private ContactResponseMapper mapper;

    @PostMapping("/list")
    public ResponseEntity<?> createContactList(@Valid @RequestBody ContactListCreateRequest contactListCreateRequest) {
        ContactList contactList = contactService.createContactList(contactListCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactList);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllContactLists(Pageable pageable) {
        Page<ContactList> contactListSet = contactService.getContactLists(pageable);
        return ResponseEntity.ok().body(mapper.allContactLists(contactListSet));
    }

    @GetMapping("/list/details")
    public ResponseEntity<?> getContactListDetails(@RequestParam UUID contactListId) {
        ContactList contactList = contactService.getContactListDetails(contactListId);
        return ResponseEntity.ok().body(mapper.contactListDetailsResponse(contactList));
    }

    @PostMapping("")
    public ResponseEntity<?> createContact(@Valid @RequestBody ContactCreateRequest contactCreateRequest) {
        Contact contact = contactService.createContact(contactCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.contactCreateResponse(contact));
    }

    @GetMapping("")
    public ResponseEntity<?> getContactDetails(@RequestParam UUID contactId) {
        Contact contact = contactService.getContactDetails(contactId);
        return ResponseEntity.ok().body(mapper.contactDetailsResponse(contact));
    }

}
