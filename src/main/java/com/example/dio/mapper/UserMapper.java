package com.example.dio.mapper;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface UserMapper {
    public void mapToUserEntity(RegisterRequest registerRequest, @MappingTarget User user);

    public void mapToNewUser(UserRequest userRequest,@MappingTarget User user);

    public UserResponse mapToUserResponse(User user);
}
