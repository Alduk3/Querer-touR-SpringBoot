package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.CompanyBranchRequest;
import com.riwi.querertourapi.api.dto.response.CompanyBranchResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ICompanyBranchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/companyBranch")
@AllArgsConstructor
public class CompanyBranchController {
    @Autowired
    private final ICompanyBranchService companyBranchService;

    @GetMapping
    public ResponseEntity<Page<CompanyBranchResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return ResponseEntity.ok(this.companyBranchService.getAll(page -1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyBranchResponse> get(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.companyBranchService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyBranchResponse> insert(
            @Validated
            @RequestBody CompanyBranchRequest companyBranch
    ){
        return ResponseEntity.ok(this.companyBranchService.create(companyBranch));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @PathVariable String id
    ){
        //Create map
        Map<String, String> response = new HashMap<>();

        //Add message
        response.put("message", "CompanyBranch delete correctly");

        //delete
        this.companyBranchService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CompanyBranchResponse> update(
            @PathVariable String id,
            @Validated
            @RequestBody CompanyBranchRequest companyBranchRequest

    ){
        return ResponseEntity.ok(this.companyBranchService.update(id, companyBranchRequest));
    }


}
