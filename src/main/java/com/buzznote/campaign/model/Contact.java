package com.buzznote.campaign.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String address;

    @JsonBackReference
    @ManyToMany(mappedBy = "contacts")
    private Set<ContactList> contactLists = new HashSet<>();
}
