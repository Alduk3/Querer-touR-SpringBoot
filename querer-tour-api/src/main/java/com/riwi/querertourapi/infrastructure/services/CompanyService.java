package com.riwi.querertourapi.infrastructure.services;

import com.riwi.querertourapi.api.dto.request.CompanyRequest;
import com.riwi.querertourapi.api.dto.response.CompanyBranchToCompanyResponse;
import com.riwi.querertourapi.api.dto.response.CompanyResponse;
import com.riwi.querertourapi.domain.entities.Company;
import com.riwi.querertourapi.domain.entities.CompanyBranch;
import com.riwi.querertourapi.domain.repositories.CompanyRepository;
import com.riwi.querertourapi.infrastructure.abstract_services.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public void delete(String id) {

        //Search for the company that correspond ID
        Company company = this.find(id);
        //Eliminate
        this.companyRepository.delete(company);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        Company company = this.requestToCompany(request, new Company());

        return this.entityToResponse(this.companyRepository.save(company));
    }

    @Override
    public CompanyResponse update(String id, CompanyRequest request) {
        //Search company by id
        Company company = this.find(id);

        Company companyUpdate = this.requestToCompany(request, company);

        return this.entityToResponse(this.companyRepository.save(companyUpdate));
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if(page < 0){
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);

        return this.companyRepository.findAll(pagination).map(this::entityToResponse);

    }

    private CompanyResponse entityToResponse(Company entity){
        CompanyResponse response = new CompanyResponse();

        BeanUtils.copyProperties(entity, response);

        response.setCompanyBranches(entity.getCompanyBranches().stream().map(companyBranch -> this.companyBranchToResponse(companyBranch)).collect(Collectors.toList()));

        return response;
    }

    private CompanyBranchToCompanyResponse companyBranchToResponse(CompanyBranch entity){
        CompanyBranchToCompanyResponse response = new CompanyBranchToCompanyResponse();
        BeanUtils.copyProperties(entity, response);

        return response;

    }

    private Company requestToCompany(CompanyRequest request, Company company){

        //it necessary to initialize the array, cause when you create company you don't have branchCompanies
        company.setCompanyBranches(new ArrayList<>());
        BeanUtils.copyProperties(request, company);

        return company;
    }

    private Company find(String id){
        return this.companyRepository.findById(id).orElseThrow();
    }
}
