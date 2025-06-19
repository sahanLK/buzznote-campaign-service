package com.buzznote.campaign.repo;

import com.buzznote.campaign.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {
}
