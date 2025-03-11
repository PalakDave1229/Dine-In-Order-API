package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import com.example.dio.enums.StockStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodItemRequest {

    @NotBlank(message = "Item name cannot be empty")
    @Size(min = 2, max = 50, message = "Item name must be between 2 and 50 characters")
    private String name;

    @Positive(message = "Item price must be greater than 0")
    private double price;

    private String description;

    @Min(value = 0, message = "Item stock cannot be negative")
    private int stock;
    private StockStatus availability;
    private DietType dietType;
    private String cuisineType;
    private List<String> categories;
}
