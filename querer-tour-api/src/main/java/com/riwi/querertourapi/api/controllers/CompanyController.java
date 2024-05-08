package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.CompanyRequest;
import com.riwi.querertourapi.api.dto.response.CompanyResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ICompanyService;
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

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
    @Autowired
    private final ICompanyService companyService;

    @Operation(
            summary = "List all the companies with pagination",
            description = "You should send the page and the size of the page to receive all the corresponding variables"

    )
    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> get(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return ResponseEntity.ok(this.companyService.getAll(page - 1 ,size));
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
            summary = "Search a company by id",
            description = "You should send the id in order to filter by id"
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.companyService.getById(id));
    }

    @Operation(
            summary = "Create a company",
            description = "Create a company"
    )
    @PostMapping
    public ResponseEntity<CompanyResponse> insert(
            @Validated
            @RequestBody CompanyRequest company
    ){
        return ResponseEntity.ok(this.companyService.create(company));
    }

    @Operation(
            summary = "Delete a company by ID",
            description = "Delete company by ID"
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        this.companyService.delete(id);

        return ResponseEntity.noContent().build();

    }

    @Operation(
            summary = "Update a company by ID",
            description = "Update company by ID"
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> update(
            @PathVariable String id,
            @Validated
            @RequestBody CompanyRequest company
    ){
        return ResponseEntity.ok(this.companyService.update(id,company));
    }

}
