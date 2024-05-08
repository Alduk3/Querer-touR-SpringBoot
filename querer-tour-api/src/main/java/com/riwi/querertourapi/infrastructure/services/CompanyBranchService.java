package com.riwi.querertourapi.infrastructure.services;

import com.riwi.querertourapi.api.dto.request.CompanyBranchRequest;
import com.riwi.querertourapi.api.dto.response.CompanyBranchResponse;
import com.riwi.querertourapi.api.dto.response.CompanyToCompanyBranchResponse;
import com.riwi.querertourapi.domain.entities.Company;
import com.riwi.querertourapi.domain.entities.CompanyBranch;
import com.riwi.querertourapi.domain.repositories.CompanyBranchRepository;
import com.riwi.querertourapi.domain.repositories.CompanyRepository;
import com.riwi.querertourapi.infrastructure.abstract_services.ICompanyBranchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyBranchService implements ICompanyBranchService {

    @Autowired
    private final CompanyBranchRepository companyBranchRepository;

    @Autowired
    private final CompanyRepository companyRepository;
    @Override
    public void delete(String id) {
        //Search
        var companyBranch = this.find(id);

        this.companyBranchRepository.delete(companyBranch);
    }

    @Override
    public CompanyBranchResponse create(CompanyBranchRequest request) {
        //search for id of company that is valid inside request
        Company company = this.companyRepository.findById(request.getCompanyId())
                .orElseThrow();

        ////Convert request to entity
        CompanyBranch companyBranch = this.requestToCompanyBranch(request, new CompanyBranch());

        //Save Company
        companyBranch.setCompany(company);

        return this.entityToResponse(this.companyBranchRepository.save(companyBranch));
    }

    @Override
    public CompanyBranchResponse update(String id, CompanyBranchRequest request) {

        //Search company by id
        CompanyBranch companyBranch = this.find(id);

        Company company = this.companyRepository.findById(request.getCompanyId()).orElseThrow();

        companyBranch = this.requestToCompanyBranch(request, companyBranch);

        //Update Company
        companyBranch.setCompany(company);

        return this.entityToResponse(this.companyBranchRepository.save(companyBranch));

    }

    @Override
    public Page<CompanyBranchResponse> getAll(int page, int size) {

        if(page < 0){
            page = 0;
        }

        //Create the pagination
        PageRequest pagination = PageRequest.of(page,size);

        //Get all company-branch of DB and map to dto response

        return this.companyBranchRepository.findAll(pagination).map(companyBranch -> this.entityToResponse(companyBranch));
    }

    @Override
    public CompanyBranchResponse getById(String id) {
        return null;
    }

    private CompanyBranchResponse entityToResponse(CompanyBranch companyBranch){
        //Create instance of response
        CompanyBranchResponse response = new CompanyBranchResponse();

        //Copy properties of entity to dto of response
        BeanUtils.copyProperties(companyBranch, response);

        //Create instance of dto of company inside branch_Company
        CompanyToCompanyBranchResponse companyResp = new CompanyToCompanyBranchResponse();

        //Copy properties of entity in dto of response
        BeanUtils.copyProperties(companyBranch.getCompany(), companyResp);

        //Add dto of response of comapny in the general response
        response.setCompany(companyResp);
        return response;


    }
    private CompanyBranch requestToCompanyBranch(CompanyBranchRequest request, CompanyBranch entity){
        BeanUtils.copyProperties(request, entity);

        return entity;
    }

    private CompanyBranch find(String id){
        return this.companyBranchRepository.findById(id).orElseThrow();
    }
}
