package com.buzznote.campaign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts", uniqueConstraints = @UniqueConstraint(name = "unique_address", columnNames = "address"))
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String address;

    @ManyToMany(mappedBy = "contacts")
    private Set<ContactList> contactLists = new HashSet<>();
}
