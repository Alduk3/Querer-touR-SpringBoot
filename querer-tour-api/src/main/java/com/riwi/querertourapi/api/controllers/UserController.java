package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.UserRequest;
import com.riwi.querertourapi.api.dto.response.UserResponse;
import com.riwi.querertourapi.domain.entities.User;
import com.riwi.querertourapi.infrastructure.abstract_services.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor

@Tag(name = "Users0")
public class UserController {

    @Autowired
    private final IUserService userService;

    @GetMapping(path = "/user")
    public ResponseEntity<Page<UserResponse>> getAllUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(this.userService.getAll(page - 1, size));
    }

    @GetMapping(path = {"/user/{id}"})
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @PostMapping(path = "/public/user")
    public ResponseEntity<UserResponse> createUser( @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(this.userService.create(userRequest));
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
         this.userService.delete(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
       return ResponseEntity.ok(this.userService.update(id, userRequest));
    }
}
