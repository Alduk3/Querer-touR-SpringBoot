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
@RequestMapping("/users")
@AllArgsConstructor
//@Validated
//@Tag(name = "Users")
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(this.userService.getAll(page - 1, size));
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(this.userService.create(userRequest));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
         this.userService.delete(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
       return ResponseEntity.ok(this.userService.update(userRequest, id));
    }
}
