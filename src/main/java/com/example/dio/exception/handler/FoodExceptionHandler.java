package com.example.dio.exception.handler;

import com.example.dio.exception.FoodNotFoundException;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.SimpleErrorRespond;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SimpleErrorRespond> RestaurantNotFoundException(FoodNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}
