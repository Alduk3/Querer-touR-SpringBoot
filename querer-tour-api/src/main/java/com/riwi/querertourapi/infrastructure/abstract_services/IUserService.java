package com.querertour.QuerertouR.infrastructure.abstract_services;


import com.querertour.QuerertouR.api.dto.request.UserRequest;
import com.querertour.QuerertouR.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, Integer> {
    final String FIELD_BY_SORT = "document";

}
