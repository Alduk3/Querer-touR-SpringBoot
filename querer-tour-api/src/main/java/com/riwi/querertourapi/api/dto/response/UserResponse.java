package com.riwi.querertourapi.api.dto.response;

import com.riwi.querertourapi.util.enums.DocType;
import com.riwi.querertourapi.util.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
    private Integer id;
    private String name;
    private String lastname;
    private DocType documentType;
    private Integer document;
    private String email;
//    private String password;
    private RoleUser roleUser;

}
