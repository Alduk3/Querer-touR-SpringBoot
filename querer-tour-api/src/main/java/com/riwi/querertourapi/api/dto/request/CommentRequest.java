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
public class CommentRequest {
    @NotBlank(message = "The comment can't be empty")
    private String comment;
    private String img;
    @NotBlank(message = "The rating can't be empty")
    private String rating;
    @NotBlank(message = "The user id can't be null")
    private String user_id;
    private String id_where;
}
