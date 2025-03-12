package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantResponse {

    private Long restaurantId;

    private String name;

    private String address;

    private String contactNumber;

    private String contactEmail;

    private LocalTime opensAt;

    private LocalTime closesAt;

    private List<DietType> dietTypes;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    private List<String> cuisineTypes;
}
