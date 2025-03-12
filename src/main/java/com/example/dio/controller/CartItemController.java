package com.example.dio.controller;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.service.CartItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${app.base-url}")
@RestController
@AllArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping("/tables/{tableid}/cart-items/food-items/{foodid}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> createCartItem(@PathVariable long tableid, @PathVariable long foodid, @RequestParam int quantity){

        return ResponseBuilder.created(cartItemService.createCartItem(tableid,foodid,quantity), "Cart item Created");

    }

    @PatchMapping("/cart-items/{cartId}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> updateQuantity(@PathVariable long cartId,@RequestParam int qunatity){
        return ResponseBuilder.OK(cartItemService.updateQuantity(cartId,qunatity), "Cart Quantity updated");
    }
}
