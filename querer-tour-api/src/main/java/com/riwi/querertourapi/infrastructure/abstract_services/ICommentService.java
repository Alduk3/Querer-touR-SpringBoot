package com.riwi.querertourapi.infrastructure.abstract_services;

import com.riwi.querertourapi.api.dto.request.CommentRequest;
import com.riwi.querertourapi.api.dto.response.CommentResponse;

public interface ICommentService extends CrudService<CommentRequest, CommentResponse, Long>{
}
