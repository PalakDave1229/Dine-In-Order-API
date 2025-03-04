package com.example.dio.service;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;


public interface UserService {
    public UserResponse registerUser(RegisterRequest registerRequest);

    UserResponse findUserById(long userId);
    UserResponse updateUserById(UserRequest userRequest, long userId);
}
