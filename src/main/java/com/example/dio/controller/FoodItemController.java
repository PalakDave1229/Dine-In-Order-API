package com.example.dio.controller;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.service.FoodItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;


    @PostMapping("/fooditems/restaurants/{id}")
    public ResponseEntity<ResponseStructure<FoodItemResponse>> createFoodItem(@PathVariable long id, @RequestBody FoodItemRequest foodItemRequest){
        System.out.println(foodItemRequest.getDescription());
        System.out.println(foodItemRequest.getAvailability());
        FoodItemResponse foodItemResponse = foodItemService.createFoodItem(id,foodItemRequest);

        return ResponseBuilder.created(foodItemResponse,"FoodItem Added successfully");
    }

}
