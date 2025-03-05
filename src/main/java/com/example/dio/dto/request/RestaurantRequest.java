package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotEmpty(message = "Username cannot be null or blank!")
    @NotBlank(message = "Username cannot be black")
    @Size(min = 3, max = 50, message = "Restaurant name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address;

    @NotBlank(message = "Contact number cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Contact number must be a valid 10-digit number")
    private String contactNumber;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String contactEmail;

    private LocalTime opensAt;

    private LocalTime closesAt;

    private List<DietType> DietTypes;

    private List<String> cuisines;

}
