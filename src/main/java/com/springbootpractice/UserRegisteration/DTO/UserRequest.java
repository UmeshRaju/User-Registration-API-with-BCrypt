package com.springbootpractice.UserRegisteration.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "user name cannot be blank")
    private String username;
    @NotBlank(message = "user name cannot be blank")
    private String userpassword;
}
