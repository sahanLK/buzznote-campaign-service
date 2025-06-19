package com.buzznote.campaign.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class ContactList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "contact_list_contact",
            joinColumns = @JoinColumn(name = "contact_list_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Set<Contact> contacts;

    @ManyToMany(mappedBy = "contactLists")
    private Set<Campaign> campaigns = new HashSet<>();

}
