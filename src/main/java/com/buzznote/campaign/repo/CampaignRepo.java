package com.buzznote.campaign.repo;

import com.buzznote.campaign.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Integer> {

}
