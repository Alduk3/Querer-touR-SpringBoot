package com.riwi.querertourapi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteResponse {

    private String id;
    private String name;
    private String audio;
    private String location;
    private String description;
    private String qr;
    private TownResponse town;
    //private List<CompanyBranchResponse> companyBranches;
}
