package com.example.dio.dto.response;

import com.example.dio.enums.StockStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CartItemResponse {

    private long itemId;
    private FoodItemResponse foodItem;
    private int quantity;
    private double totalPrice;
    private StockStatus availability;
    private LocalDate createdAt;
    private LocalDateTime lastModifiedAt;
}
