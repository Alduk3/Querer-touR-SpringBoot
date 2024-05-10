package com.riwi.querertourapi.api.error_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)// Not to generate two spaces in memory
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ErrorResponse extends BaseErrorResponse{
    private String message;
}

