package com.riwi.querertourapi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {
    private String id;
    private String nit;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String area;

}
