package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import com.example.dio.enums.StockStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemRequest {

    private String name;
    private double price;
    private String description;
    private int stock;
    private StockStatus availability;
    private DietType dietType;
    private String cuisineType;
}
