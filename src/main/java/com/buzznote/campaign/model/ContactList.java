package com.buzznote.campaign.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "contact_lists",
        uniqueConstraints = @UniqueConstraint(name= "unique contact_list name", columnNames = "name"))
@Entity
public class ContactList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "contact_list_contacts",
            joinColumns = @JoinColumn(name = "contact_list_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"),
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"contact_list_id", "contact_id"})
            }
    )
    private Set<Contact> contacts;

    @ManyToMany(mappedBy = "contactLists")
    private Set<Campaign> campaigns = new HashSet<>();

}
