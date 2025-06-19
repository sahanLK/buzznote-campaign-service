package com.buzznote.campaign.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String address;

    @ManyToMany(mappedBy = "contacts")
    private Set<ContactList> contactLists;
}
