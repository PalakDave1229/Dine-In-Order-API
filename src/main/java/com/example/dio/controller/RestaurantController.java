package com.example.dio.controller;
import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.service.RestoService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class RestaurantController {

    private RestoService restoService;

    @PostMapping("/Restaurant/{userId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> createRestaurant(
            @PathVariable long userId, @RequestBody RestaurantRequest restaurantRequest
            ){
        RestaurantResponse restaurantResponse =
                restoService.createRestaurant(userId, restaurantRequest);
        return ResponseBuilder.created(
                restaurantResponse, "Restaurant Added Successfully"
        );
    }

}
