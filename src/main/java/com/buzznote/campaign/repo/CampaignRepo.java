package com.buzznote.campaign.repo;

import com.buzznote.campaign.model.Campaign;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, UUID> {
    @NotNull Page<Campaign> findAll(@NotNull Pageable pageable);
}
