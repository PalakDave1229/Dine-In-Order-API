package com.example.dio.service;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;

import java.util.List;

public interface FoodItemService {

    public FoodItemResponse createFoodItem(long id, FoodItemRequest foodItemRequest);
    public List<FoodItemResponse> findByTwoCategories(List<String> categories);
    public List<FoodItemResponse> findByRestaurantId(long restaurantId);
}
