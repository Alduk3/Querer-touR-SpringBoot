package com.riwi.querertourapi.domain.repositories;

import com.riwi.querertourapi.domain.entities.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, String> {
}
