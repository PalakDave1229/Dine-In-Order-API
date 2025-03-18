package com.example.dio.mapper;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Category;
import com.example.dio.model.CuisineType;
import com.example.dio.model.FoodItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component

public interface FoodItemMapper {

    public FoodItem mapToFoodItem(FoodItemRequest foodItemRequest);
    public FoodItemResponse mappToFoodItemResponse (FoodItem foodItem);
    public List<FoodItemResponse> mapToListOfFoodItemResponse(List<FoodItem> foodItems);

    default String mapToString(CuisineType value) {
        if(value == null) {
            return null;
        }
        else return value.getCuisine().toLowerCase();
    }

    default  String mapToString(Category value){
        if(value == null){
            return null;
        }
        else return value.getCategory().toLowerCase();
    }

    default CuisineType mapToCuisineType(String value) {
        if(value == null) {
            return null;
        }
        else {
            CuisineType type = new CuisineType();
            type.setCuisine(value.toLowerCase());
            return type;
        }
    }

    default  Category mapToCategory(String value){
        if(value == null)
        {
            return null;
        }
       else{
           Category type = new Category();
           type.setCategory(value.toLowerCase());
           return type;
        }
    }
}
