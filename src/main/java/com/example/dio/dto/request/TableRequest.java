package com.example.dio.dto.request;

import com.example.dio.enums.TableStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequest {

    @Min(value = 1, message = "Table number must be greater than zero")
    @Pattern(regexp = "\\d+", message = "Table number must contain only digits")
    private long tableNo;

    @Min(value = 1, message = "Table capacity must be greater than zero")
    @Pattern(regexp = "\\d+", message = "Table capacity must contain only digits")
    private long tableCapacity;

    private TableStatus status;
}
