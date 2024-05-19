package com.riwi.querertourapi.infrastructure.services;

import com.riwi.querertourapi.api.dto.request.SiteRequest;
import com.riwi.querertourapi.api.dto.response.CompanyBranchResponse;
import com.riwi.querertourapi.api.dto.response.CompanyBranchToCompanyResponse;
import com.riwi.querertourapi.api.dto.response.SiteResponse;
import com.riwi.querertourapi.api.dto.response.TownResponse;
import com.riwi.querertourapi.domain.entities.CompanyBranch;
import com.riwi.querertourapi.domain.entities.Site;
import com.riwi.querertourapi.domain.entities.Town;
import com.riwi.querertourapi.domain.repositories.CompanyBranchRepository;
import com.riwi.querertourapi.domain.repositories.SiteRepository;
import com.riwi.querertourapi.domain.repositories.TownRepository;
import com.riwi.querertourapi.infrastructure.abstract_services.ISiteService;
import com.riwi.querertourapi.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SiteService implements ISiteService {

    @Autowired
    private final SiteRepository siteRepository;

    @Autowired
    private final TownRepository townRepository;

    @Override
    public SiteResponse create(SiteRequest request) {
        Town town = this.findTown(request.getTown_id());

        Site site = this.requestToSite(request, new Site());

        site.setTown(town);

        return this.entityToResponse(this.siteRepository.save(site));
    }

    @Override
    public SiteResponse getById(String id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public SiteResponse update(String id, SiteRequest request) {
        Site site = this.find(id);
        Town town = this.findTown(request.getTown_id());

        site = this.requestToSite(request, site);

        site.setTown(town);
        return this.entityToResponse(this.siteRepository.save(site));
    }

    @Override
    public void delete(String id) {
        Site site = this.find(id);
        this.siteRepository.delete(site);
    }

    @Override
    public Page<SiteResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.siteRepository.findAll(pagination).map(this::entityToResponse);
    }

    private Site find(String id) {
        return this.siteRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Site"));
    }

    private Town findTown(String id) {
        return this.townRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Town"));
    }

    private SiteResponse entityToResponse(Site site) {
        SiteResponse response = new SiteResponse();
        BeanUtils.copyProperties(site, response);

        //response.setCompanyBranches(site.getCompanyBranches().stream().map(companyBranch -> this.companyBranchToResponse(companyBranch)).collect(Collectors.toList()));

        response.setTown(townResponse(site.getTown()));


        return response;
    }

    private TownResponse townResponse(Town town){
        TownResponse response = new TownResponse();
        BeanUtils.copyProperties(town, response);
        return response;
    }

    private CompanyBranchResponse companyBranchToResponse(CompanyBranch entity){
        CompanyBranchResponse response = new CompanyBranchResponse();
        BeanUtils.copyProperties(entity, response);

        return response;

    }

    private Site requestToSite(SiteRequest request, Site site) {
        BeanUtils.copyProperties(request, site);
        return site;
    }
}
