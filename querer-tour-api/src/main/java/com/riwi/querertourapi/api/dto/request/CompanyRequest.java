package com.riwi.querertourapi.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String nit;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String area;
}

