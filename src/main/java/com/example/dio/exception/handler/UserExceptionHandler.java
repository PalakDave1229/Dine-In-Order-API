package com.example.dio.exception.handler;

import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.SimpleErrorRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorRespond> handleUserNotFoundById(UserNotFoundByIdException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<SimpleErrorRespond> handleAccessDeniedException(AccessDeniedException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}
