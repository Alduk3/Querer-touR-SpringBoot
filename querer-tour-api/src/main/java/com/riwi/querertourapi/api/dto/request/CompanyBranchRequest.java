package com.riwi.querertourapi.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyBranchRequest {
    private String name;
    private String id_site;
    private String companyId;
}
