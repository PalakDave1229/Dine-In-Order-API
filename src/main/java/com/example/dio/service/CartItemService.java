package com.example.dio.service;

import com.example.dio.dto.response.CartItemResponse;

public interface CartItemService {

    public CartItemResponse createCartItem(long table,long foodId, int quantity);

    public CartItemResponse updateQuantity(long cartId, int quantity);
}
