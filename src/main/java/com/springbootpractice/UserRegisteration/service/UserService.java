package com.springbootpractice.UserRegisteration.service;

import com.springbootpractice.UserRegisteration.DTO.UserRequest;
import com.springbootpractice.UserRegisteration.Repository.UserRepository;
import com.springbootpractice.UserRegisteration.Util.JwtService;
import com.springbootpractice.UserRegisteration.model.User;
import com.springbootpractice.UserRegisteration.config.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();

        user.setUsername(userRequest.getUsername());
        user.setUserpassword(passwordEncoder.encode(userRequest.getUserpassword()));

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // New Method : validate Login
    // Update the login check to return a Token String instead of boolean
    public String checkLogin(String username,String rawPassword) {
        User user = userRepository.findByUsername(username);
        // check if user exists
        // check if the raw password matches the hashed password in db

        if( user != null && passwordEncoder.matches(rawPassword, user.getUserpassword())){
            // Generate and return the token !
            return JwtService.generateToken(username);
        }

        return "failed";


    }
}
