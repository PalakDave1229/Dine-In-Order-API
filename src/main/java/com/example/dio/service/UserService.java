package com.example.dio.service;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;


public interface UserService {

    /**
     * Registers a new user.
     * @param registerRequest User registration request data
     * @return UserResponse containing user details
     */

    public UserResponse registerUser(RegisterRequest registerRequest);

    /**
     * Finds a user by their ID.
     * @param userId ID of the user
     * @return UserResponse containing user details
     */
    
    UserResponse findUserById(long userId);

    /**
     * Updates a user by their ID.
     * @param userRequest Updated user details
     * @param userId ID of the user to be updated
     * @return UserResponse containing updated user details
     */

    UserResponse updateUserById(UserRequest userRequest, long userId);

}
