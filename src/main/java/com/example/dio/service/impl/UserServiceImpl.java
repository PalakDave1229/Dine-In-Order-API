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

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegisterRequest registerRequest){
        User user = this.createUserByRole(registerRequest.getUserRole());

        userMapper.mapToUserEntity(registerRequest, user);

        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    private User createUserByRole(UserRole role){
        User user;
        switch (role){
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invalid User");
        }
        return user;
    }

    @Override
    public UserResponse findUserById(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find User,user not found by Id"));
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUserById(UserRequest userRequest, long userId){
        User exUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to Update user, user not found by id"));

        userMapper.mapToNewUser(userRequest, exUser);
        User user = userRepository.save(exUser);
        return userMapper.mapToUserResponse(user);


    }
}
