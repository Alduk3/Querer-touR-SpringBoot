
package com.riwi.querertourapi.api.dto.errors;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//SupeBuilder creates a constructor with the super of Serializable
@SuperBuilder
public class BaseErrorResponse implements Serializable {
    private String status;
    private Integer code;
}
