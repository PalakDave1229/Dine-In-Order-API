package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotEmpty(message = "Username cannot be null or blank!")
    @NotBlank(message = "Username cannot be black")
    @Pattern(regexp = "^[a-zA-z0-9_]+$", message = "Username can only contain Alphabets, Numbers and Underscore")
    private String username;

    @NotEmpty(message = "Email cannot be null or blank")
    @NotBlank(message = "Email cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Only Gmail addresses are allowed (@gmail.com) is required")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W_])(?!.*\\s)[A-Za-z\\d\\W_]{8,12}$", message = "Password must contain at least one uppercase letter , lowercase letter, digit, special character, not contain spaces")
    private String password;

    private UserRole userRole;



}
