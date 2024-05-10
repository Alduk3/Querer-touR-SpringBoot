package com.riwi.querertourapi.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyBranchRequest {
    @Size(min = 0, max = 100, message = "Name gets over the quantity of characters allowed")
    @NotBlank(message = "Name of branch company is required")
    private String name;
    private String id_site;
    @NotBlank(message = "CompanyId is required")
    private String companyId;
}
