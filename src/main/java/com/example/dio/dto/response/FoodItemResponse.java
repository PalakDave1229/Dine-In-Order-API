package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import com.example.dio.enums.StockStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FoodItemResponse {

    private long id;
    private String name;
    private double price;
    private String description;
    private StockStatus availability;
    private DietType dietType;
    private String cuisineType;
    private LocalDate createdat;
    private LocalDateTime lastmodifiedat;
}
