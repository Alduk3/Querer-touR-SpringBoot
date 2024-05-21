package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.CompanyBranchRequest;
import com.riwi.querertourapi.api.dto.response.CompanyBranchResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ICompanyBranchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@AllArgsConstructor
public class CompanyBranchController {
    @Autowired
    private final ICompanyBranchService companyBranchService;

    @Operation(
            summary = "List all company branches with pagination",
            description = "You should send the page and the size of the page to receive all the corresponding variables"
    )
    @GetMapping(path = "/public/companyBranch")
    public ResponseEntity<Page<CompanyBranchResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return ResponseEntity.ok(this.companyBranchService.getAll(page -1, size));
    }

    @ApiResponse(
            responseCode = "400",
            description = "When the id is not valid",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation(
            summary = "Search a companyBranch by id",
            description = "You should send the id in order to filter by id"
    )
    @GetMapping(path = "/companyBranch/{id}")
    public ResponseEntity<CompanyBranchResponse> get(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.companyBranchService.getById(id));
    }

    @Operation(
            summary = "Create a company branch",
            description = "Create a company branch"
    )
    @PostMapping(path = "/companyBranch")
    public ResponseEntity<CompanyBranchResponse> insert(
            @Validated
            @RequestBody CompanyBranchRequest companyBranch
    ){
        return ResponseEntity.ok(this.companyBranchService.create(companyBranch));
    }

    @Operation(
            summary = "Delete a company branch by ID",
            description = "Delete company branch by ID"
    )
    @DeleteMapping(path = "/companyBranch/{id}")
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

    @Operation(
            summary = "Update a company branch by ID",
            description = "Update a company branch by ID"
    )
    @PutMapping(path = "/companyBranch/{id}")
    public ResponseEntity<CompanyBranchResponse> update(
            @PathVariable String id,
            @Validated
            @RequestBody CompanyBranchRequest companyBranchRequest

    ){
        return ResponseEntity.ok(this.companyBranchService.update(id, companyBranchRequest));
    }


}
