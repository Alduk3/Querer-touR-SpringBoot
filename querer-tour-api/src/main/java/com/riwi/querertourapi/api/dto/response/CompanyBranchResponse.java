package com.riwi.querertourapi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyBranchResponse {
    private String id;
    private String name;
    private String id_site;
    private CompanyToCompanyBranchResponse company;
}
