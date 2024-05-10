package com.querertour.QuerertouR.api.dto.request;

import com.querertour.QuerertouR.utils.enums.DocType;
import com.querertour.QuerertouR.utils.enums.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserRequest {
    @NotBlank(message = "This field is mandatory.")
    @Size(min = 1, max = 50, message = "Name must have 1-50 characters")
    private String name;

    @NotBlank(message = "This field is mandatory.")
    @Size(min = 1, max = 50, message = "LastName must have 1-50 characters")
    private String lastname;

    @NotBlank(message = "This field is mandatory.")
    private DocType documentType;

    @NotNull(message = "This field is mandatory.")
    @Min(value = 5, message = "Invalid document number.")
    private Integer document;

    @Email(message = "This field is mandatory.")
    private String email;

    @Size(min = 8, max = 32, message = "Password must have at least 8 characters")
    @NotBlank(message = "This field is mandatory.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @NotBlank(message = "This field is mandatory.")
    private Role role;

}
