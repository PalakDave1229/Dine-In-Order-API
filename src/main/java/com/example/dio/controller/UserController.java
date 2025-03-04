package com.example.dio.controller;

import com.example.dio.dto.request.RegisterRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.util.FieldErrorResponse;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import com.example.dio.util.SimpleErrorRespond;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "User Controller", description = "Collection of APIs Endpoints dealing with user data")
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    @Operation(description = """
            The API end-points is used to register user based on role ADMIN and STAFF
            """,
    responses = {
            @ApiResponse(responseCode = "201", description = "User Created"),
            @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                    @Content(schema = @Schema(implementation = FieldErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegisterRequest registerRequest) {
        UserResponse response = userService.registerUser(registerRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created", response);
    }

   @GetMapping("/users/{userId}")
   @Operation(description = """
           The API end-points is used to Find User Details By ID.
           """,
   responses = {
           @ApiResponse(responseCode = "201", description = "User Founded"),
           @ApiResponse(responseCode = "404", description = "User Not Found", content = {
                   @Content(schema = @Schema(implementation = SimpleErrorRespond.class))
           })
   })
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId){
        UserResponse userResponse = userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Found", userResponse);

   }
   @PutMapping("/users/{userId}")
   @Operation(description = """
           The API end-points is used to Update User Details By ID.
           """,
           responses = {
                   @ApiResponse(responseCode = "201", description = "User Updated Successfully"),
                   @ApiResponse(responseCode = "404", description = "User Not Found", content = {
                           @Content(schema = @Schema(implementation = SimpleErrorRespond.class))
                   }),
                   @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                           @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                   })
           })
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@RequestBody UserRequest userRequest, @PathVariable long  userId){
        UserResponse userResponse = userService.updateUserById(userRequest, userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Updated", userResponse);
   }
}
