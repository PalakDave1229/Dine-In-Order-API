package com.example.dio.service.impl;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.*;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface for handling user-related operations.
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Registers a new user based on their role.
     * @param registerRequest DTO containing user registration details
     * @return UserResponse containing user details after successful registration
     */

    @Override
    public UserResponse registerUser(RegisterRequest registerRequest){
        User user = this.createUserByRole(registerRequest.getUserRole());

        userMapper.mapToUserEntity(registerRequest, user);

        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    /**
     * Creates a user entity based on the provided role.
     * @param role UserRole enum specifying the type of user
     * @return User object corresponding to the specified role
     */

    private User createUserByRole(UserRole role){
        User user;
        switch (role){
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invalid User");
        }
        return user;
    }

    /**
     * Finds a user by their ID.
     * @param userId ID of the user to be retrieved
     * @return UserResponse containing user details
     * @throws UserNotFoundByIdException if no user is found with the given ID
     */

    @Override
    public UserResponse findUserById(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find User,user not found by Id"));
        return userMapper.mapToUserResponse(user);
    }

    /**
     * Updates a user's details by their ID.
     * @param userRequest DTO containing updated user information
     * @param userId ID of the user to be updated
     * @return UserResponse containing updated user details
     * @throws UserNotFoundByIdException if no user is found with the given ID
     */

    @Override
    public UserResponse updateUserById(UserRequest userRequest, long userId){
        User exUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to Update user, user not found by id"));

        userMapper.mapToNewUser(userRequest, exUser);
        User user = userRepository.save(exUser);
        return userMapper.mapToUserResponse(user);


    }
}
