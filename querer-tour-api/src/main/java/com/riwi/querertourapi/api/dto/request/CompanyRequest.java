package com.riwi.querertourapi.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    @Size(min = 0, max = 12, message = "nit gets over the quantity of characters allowed")
    @NotBlank(message = "nit of the company is required")
    private String nit;
    @Size(min = 0, max = 100, message = "name of company gets over the quantity of characters allowed")
    @NotBlank(message = "name of the company is required")
    private String name;
    @Size(min = 0, max = 12, message = "phone gets over the quantity of characters allowed")
    @NotBlank(message = "phone of the company is required")
    private String phone;
    @Size(min = 0, max = 100, message = "address gets over the quantity of characters allowed")
    @NotBlank(message = "address of the company is required")
    private String address;
    @Size(min = 0, max = 100, message = "email gets over the quantity of characters allowed")
    @NotBlank(message = "email of the company is required")
    private String email;
    @Size(min = 0, max = 12, message = "area gets over the quantity of characters allowed")
    @NotBlank(message = "area of the company is required")
    private String area;
}

