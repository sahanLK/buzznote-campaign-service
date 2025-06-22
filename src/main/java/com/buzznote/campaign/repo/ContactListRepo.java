package com.buzznote.campaign.repo;

import com.buzznote.campaign.model.ContactList;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactListRepo extends JpaRepository<ContactList, UUID> {
    @NotNull Page<ContactList> findAll(@NotNull Pageable pageable);
}
