package com.riwi.querertourapi.domain.repositories;

import com.riwi.querertourapi.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
