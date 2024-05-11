package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService IuserService;
}
