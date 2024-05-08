package com.riwi.querertourapi.infrastructure.abstract_services;

import com.riwi.querertourapi.api.dto.request.CompanyRequest;
import com.riwi.querertourapi.api.dto.response.CompanyResponse;

public interface ICompanyService extends CrudService<CompanyRequest, CompanyResponse, String>{
    public CompanyResponse getById(String id);
}
