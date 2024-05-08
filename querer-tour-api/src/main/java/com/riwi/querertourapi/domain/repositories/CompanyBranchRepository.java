package com.riwi.querertourapi.domain.repositories;

import com.riwi.querertourapi.domain.entities.CompanyBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyBranchRepository extends JpaRepository<CompanyBranch, String> {
}
