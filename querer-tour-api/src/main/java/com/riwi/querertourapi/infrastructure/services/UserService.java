package com.riwi.querertourapi.infrastructure.services;

import com.riwi.querertourapi.api.controllers.UserController;
import com.riwi.querertourapi.api.dto.request.UserRequest;
import com.riwi.querertourapi.api.dto.response.UserResponse;
import com.riwi.querertourapi.domain.entities.User;
import com.riwi.querertourapi.domain.repositories.UserRepository;
import com.riwi.querertourapi.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private UserController userController;

    @Override
    public Page<UserResponse> getAll(int page, int size, SortOrder sort) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(this::UserToUserResponse);
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = new User();
        return null;
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

//    private User userRequestToUser(UserRequest userRequest) {
//        return User.builder()
//                .name(userRequest.getName())
//                .lastname(userRequest.getLastname())
//                .documentType(userRequest.getDocumentType())
//                .email(userRequest.getEmail())
//                .password((userRequest.getPassword()))
//                .roleUser(userRequest.getRole())
//                .build();
//    }

    private UserResponse UserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

}
