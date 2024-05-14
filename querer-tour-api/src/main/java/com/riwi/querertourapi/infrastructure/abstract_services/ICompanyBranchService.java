package com.riwi.querertourapi.infrastructure.abstract_services;

import com.riwi.querertourapi.api.dto.request.CompanyBranchRequest;
import com.riwi.querertourapi.api.dto.response.CompanyBranchResponse;
import com.riwi.querertourapi.domain.repositories.CompanyBranchRepository;

public interface ICompanyBranchService extends CrudService<CompanyBranchRequest, CompanyBranchResponse,String>{
    public CompanyBranchResponse getById(String id);
}
