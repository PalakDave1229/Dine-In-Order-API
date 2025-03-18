package com.example.dio.mapper;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.model.CuisineType;
import com.example.dio.model.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting Restaurant DTOs to entities and vice versa.
 * Utilizes MapStruct for object mapping.
 */

@Mapper(componentModel = "spring")
@Component
public interface RestaurantMapper {

    /**
     * Maps a RestaurantRequest DTO to a Restaurant entity.
     * @param restaurantRequest DTO containing restaurant details
     * @return Restaurant entity mapped from the DTO
     */

    Restaurant mapToRestaurantEntity(RestaurantRequest restaurantRequest);

    /**
     * getting string value and storing in CuisineType object
     *
     * @param value cuisine type getting in string type
     * @return object of cuisine with string name
     */

    default CuisineType mapToCuisineType(String value){
        if(value == null){
            return null;
        }else{
            CuisineType type = new CuisineType();
            type.setCuisine(value);
            return type;
        }
    }

    /**
     * converting cuisine type into String for restaurant response
     *
     * @param value cuisineType object with name
     * @return cuisine name as string
     */
    default  String mapToString(CuisineType value){
        if(value == null){
            return null;
        }else return value.getCuisine();
    }

    /**
     * Maps a Restaurant entity to a RestaurantResponse DTO.
     * @param restaurant Restaurant entity
     * @return RestaurantResponse DTO containing restaurant details
     */

    RestaurantResponse mapToRestaurantResponse(Restaurant restaurant);
}
