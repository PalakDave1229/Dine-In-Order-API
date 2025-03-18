package com.example.dio.controller;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.service.FoodItemService;
import com.example.dio.util.ListResponseStructure;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;


    @PostMapping("/fooditems/restaurants/{id}")
    public ResponseEntity<ResponseStructure<FoodItemResponse>> createFoodItem(@PathVariable long id, @RequestBody FoodItemRequest foodItemRequest){
        FoodItemResponse foodItemResponse = foodItemService.createFoodItem(id,foodItemRequest);

        return ResponseBuilder.created(foodItemResponse,"FoodItem Added successfully");
    }

    @GetMapping("/fooditems/categories")
    public ResponseEntity<ListResponseStructure<FoodItemResponse>> findByCategories(@RequestParam List<String> categories){
        return ResponseBuilder.ok(foodItemService.findByTwoCategories(categories), "Food item List found according categories");
    }

    @GetMapping("/fooditems/restaurant/{restaurantId}")
    public ResponseEntity<ListResponseStructure<FoodItemResponse>> findByRestaurantId(@PathVariable long restaurantId){
        return ResponseBuilder.ok(foodItemService.findByRestaurantId(restaurantId), "Food item List found according restaurant");
    }

}
