package com.riwi.querertourapi.infrastructure.abstract_services;


import com.riwi.querertourapi.api.dto.request.UserRequest;
import com.riwi.querertourapi.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, String> {
    final String FIELD_BY_SORT = "document";

}
