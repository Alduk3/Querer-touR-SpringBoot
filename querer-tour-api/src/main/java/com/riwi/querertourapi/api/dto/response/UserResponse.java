package com.querertour.QuerertouR.api.dto.response;

import com.querertour.QuerertouR.utils.enums.DocType;
import com.querertour.QuerertouR.utils.enums.Role;
import jakarta.persistence.*;
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
    private Role role;

}
