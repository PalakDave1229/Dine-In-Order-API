package com.example.dio.mapper;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting DTOs to User entity and vice versa.
 * Utilizes MapStruct for object mapping.
 */

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    /**
     * Maps RegisterRequest DTO to an existing User entity.
     * @param registerRequest DTO containing user registration data
     * @param user Target User entity to be updated
     */

    public void mapToUserEntity(RegisterRequest registerRequest, @MappingTarget User user);

    /**
     * Maps UserRequest DTO to an existing User entity.
     * @param userRequest DTO containing updated user data
     * @param user Target User entity to be updated
     */

    public void mapToNewUser(UserRequest userRequest,@MappingTarget User user);

    /**
     * Maps a User entity to a UserResponse DTO.
     * @param user User entity
     * @return UserResponse DTO containing user details
     */

    public UserResponse mapToUserResponse(User user);
}
