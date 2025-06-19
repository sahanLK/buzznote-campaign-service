package com.buzznote.campaign.repo;

import com.buzznote.campaign.model.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactListRepo extends JpaRepository<ContactList, UUID> {
}
