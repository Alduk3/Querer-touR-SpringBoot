package com.riwi.querertourapi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String comment;
    private String img;
    private String rating;
    // Validar lo que se necesita responser
    private UserResponse user;
    private String id_where;
}
