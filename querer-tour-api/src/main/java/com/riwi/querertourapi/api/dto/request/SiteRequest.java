package com.riwi.querertourapi.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteRequest {
    @NotBlank(message = "The name can't be empty")
    private String name;
    private String audio;
    private String location;
    @NotBlank(message = "The description can't be empty")
    private String description;
    @NotBlank(message = "The qr can't be empty")
    private String qr;
    @NotBlank(message = "The id town can't be empty")
    private String town_id;
}
