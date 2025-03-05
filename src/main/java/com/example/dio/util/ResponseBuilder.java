package com.example.dio.util;

import com.example.dio.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class ResponseBuilder {


    /**
     * Creates a success response with status, message, and data.
     * @param status HTTP status code
     * @param message Response message
     * @param data Response data
     * @return ResponseEntity containing ResponseStructure<T>
     */

        public static<T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
            ResponseStructure<T> structure = ResponseStructure.<T>builder()
                    .status(status.value())
                    .message(message)
                    .data(data)
                    .build();

            return ResponseEntity.status(status)
                    .body(structure);
    }

    /**
     * Creates a success response with headers, status, message, and data.
     * @param status HTTP status code
     * @param headers HTTP headers
     * @param message Response message
     * @param data Response data
     * @return ResponseEntity containing ResponseStructure<T>
     */

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

    /**
     * Creates an error response with status and message.
     * @param status HTTP status code
     * @param message Error message
     * @return ResponseEntity containing SimpleErrorRespond
     */

    public static ResponseEntity<SimpleErrorRespond> error(HttpStatus status, String message){
            SimpleErrorRespond error = SimpleErrorRespond.builder()
                    .type(status.name())
                    .message(message)

                    .status(status.value())
                    .build();

            return ResponseEntity.status(status)
                    .body(error);
    }

    /**
     * Creates a 200 OK response with message and data.
     * @param data Response data
     * @param message Response message
     * @return ResponseEntity containing ResponseStructure<T>
     */

    public static <T> ResponseEntity<ResponseStructure<T>> OK(T data, String message){
            return success(HttpStatus.OK, "OK",data);
    }

    /**
     * Creates a 201 Created response with message and data.
     * @param data Response data
     * @param message Response message
     * @return ResponseEntity containing ResponseStructure<T>
     */

    public static <T> ResponseEntity<ResponseStructure<T>> created(T data, String message){
            return success(HttpStatus.CREATED, "CREATED",data);
    }

    /**
     * Creates a 404 Not Found response with a message.
     * @param message Error message
     * @return ResponseEntity containing SimpleErrorRespond
     */

    public static ResponseEntity<SimpleErrorRespond> notFound(String message){
            return error(HttpStatus.NOT_FOUND, "NOT FOUND");
    }
}
