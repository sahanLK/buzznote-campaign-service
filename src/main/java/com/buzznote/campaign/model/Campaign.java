package com.buzznote.campaign.model;

import com.buzznote.campaign.model.types.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String userId;
    private String title;
    private String senderName;
    private String senderEmail;
    private String replyTo;
    private Status status;
    private LocalDateTime scheduledAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String body;

    @ManyToMany
    @JoinTable(
            name = "campaign_contact_list",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_list_id")
    )
    private Set<ContactList> contactLists = new HashSet<>();
}
