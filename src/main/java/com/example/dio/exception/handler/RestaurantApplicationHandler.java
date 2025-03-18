package com.example.dio.exception.handler;

import com.example.dio.exception.RestaurantNotFoundException;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.SimpleErrorRespond;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RestaurantApplicationHandler {

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<SimpleErrorRespond> RestaurantNotFoundException(RestaurantNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}
