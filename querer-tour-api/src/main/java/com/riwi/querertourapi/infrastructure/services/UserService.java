package com.querertour.QuerertouR.infrastructure.services;

import com.querertour.QuerertouR.api.dto.request.UserRequest;
import com.querertour.QuerertouR.api.dto.response.UserResponse;
import com.querertour.QuerertouR.domain.entities.User;
import com.querertour.QuerertouR.domain.repositories.UserRepository;
import com.querertour.QuerertouR.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;


    @Override
    public UserResponse create(UserRequest request) {
        User user = new User();

    }

    @Override
    public UserResponse getById(Integer integer) {
        return null;
    }

    @Override
    public UserResponse update(UserRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Page<UserResponse> getAll(int page, int size, SortOrder sort) {
        return null;
    }

    private User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .lastname(userRequest.getLastname())
                .documentType(userRequest.getDocumentType())
                .email(userRequest.getEmail())
                .password((userRequest.getPassword()))
                .role(userRequest.getRole())
                .build();
    }
}
