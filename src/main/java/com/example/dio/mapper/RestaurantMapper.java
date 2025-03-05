package com.example.dio.mapper;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.model.Restaurant;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting Restaurant DTOs to entities and vice versa.
 * Utilizes MapStruct for object mapping.
 */

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    /**
     * Maps a RestaurantRequest DTO to a Restaurant entity.
     * @param restaurantRequest DTO containing restaurant details
     * @return Restaurant entity mapped from the DTO
     */

    public Restaurant mapToRestaurantEntity(RestaurantRequest restaurantRequest);

    /**
     * Maps a Restaurant entity to a RestaurantResponse DTO.
     * @param restaurant Restaurant entity
     * @return RestaurantResponse DTO containing restaurant details
     */

    RestaurantResponse mapToRestaurantResponse(Restaurant restaurant);
}
