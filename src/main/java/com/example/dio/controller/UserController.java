package com.example.dio.controller;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegisterRequest registerRequest) {
        UserResponse response = userService.registerUser(registerRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created", response);
    }

   @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId){
        UserResponse userResponse = userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Found", userResponse);

   }
   @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@RequestBody UserRequest userRequest, @PathVariable long  userId){
        UserResponse userResponse = userService.updateUserById(userRequest, userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Updated", userResponse);
   }
}
