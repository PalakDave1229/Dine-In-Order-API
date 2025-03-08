package com.example.dio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserNotFoundByIdException extends RuntimeException{
    private final String message;

    public UserNotFoundByIdException(String message) {
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
