package com.example.dio.util;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@SuperBuilder
public class FieldErrorResponse extends SimpleErrorRespond{


    private List<CustomFieldError> errors;

    public static CustomFieldError createFieldError(String message, Object rejectedValue, String field){
        CustomFieldError error = new CustomFieldError();
        error.messgae = message;
        error.rejectedValue = rejectedValue;
        error.field = field;

        return error;
    }

    @Getter
    public static class CustomFieldError {
        private String messgae;
        private Object rejectedValue;
        private String field;
    }



}
