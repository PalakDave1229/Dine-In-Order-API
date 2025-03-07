package com.example.dio.util;

import com.example.dio.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class ResponseBuilder {

        public static<T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
            ResponseStructure<T> structure = ResponseStructure.<T>builder()
                    .status(status.value())
                    .message(message)
                    .data(data)
                    .build();

            return ResponseEntity.status(status)
                    .body(structure);
    }
    public static<T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .headers(headers)
                .body(structure);
    }
    public static ResponseEntity<SimpleErrorRespond> error(HttpStatus status, String message){
            SimpleErrorRespond error = SimpleErrorRespond.builder()
                    .type(status.name())
                    .message(message)

                    .status(status.value())
                    .build();

            return ResponseEntity.status(status)
                    .body(error);
    }

}
