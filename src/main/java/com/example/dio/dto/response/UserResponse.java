package com.example.dio.dto.response;

import com.example.dio.enums.UserRole;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Setter
@Getter

public class UserResponse {
    private long userid;
    private String username;
    private UserRole userRole;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
}
