package com.springbootpractice.UserRegisteration.controller;

import com.springbootpractice.UserRegisteration.DTO.UserRequest;
import com.springbootpractice.UserRegisteration.model.User;
import com.springbootpractice.UserRegisteration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User create(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    public List<User> getAll() {
        return userService.getAllUsers();
    }

    // 1. Show the login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Looks for login.html in templates
    }

    // 2. Show the Success page ( only accessible if login works )
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success"; // Looks for success.html
    }

    // 3. Process the Login Form
    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        boolean isValid = userService.checkLogin(username,password);

        if(isValid) {
            return "redirect:/success"; // redirects prevents from resubmission
        } else {
            model.addAttribute("error","Invalid Username or Password");
            return "login"; // return to login page with error
        }
    }
}
