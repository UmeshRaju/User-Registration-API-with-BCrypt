package com.springbootpractice.UserRegisteration.controller;

import com.springbootpractice.UserRegisteration.DTO.UserRequest;
import com.springbootpractice.UserRegisteration.model.User;
import com.springbootpractice.UserRegisteration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    public List<User> getAll() {
        return userService.getAllUsers();
    }

}
