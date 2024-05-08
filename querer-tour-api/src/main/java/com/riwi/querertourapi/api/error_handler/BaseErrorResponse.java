package com.riwi.querertourapi.api.error_handler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//SUpeBuilder creates a constructor with the super of Serializable
@SuperBuilder
public class BaseErrorResponse implements Serializable {
    private String status;
    private Integer code;
}
