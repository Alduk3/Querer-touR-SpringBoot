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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(this::UserToUserResponse);
    }

    @Override
    public UserResponse getById(Integer id) {
        return this.UserToUserResponse(this.find(id));

    }

    @Override
    public UserResponse create(UserRequest request) {
     User user= this.userRequestToUser(request, new User());
    return this.UserToUserResponse(this.userRepository.save(user)) ;

    }


    @Override
    public UserResponse update(UserRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    private User find(Integer id){
        return this.userRepository.findById(id).orElseThrow();
    }

    private User userRequestToUser(UserRequest userRequest, User user) {
       BeanUtils.copyProperties(userRequest, user);
        return user;
    }

    private UserResponse UserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

}
