package com.example.dio.service.impl;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.RestaurantMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.CuisineType;
import com.example.dio.model.Restaurant;
import com.example.dio.model.User;
import com.example.dio.repository.CuisineRepositiory;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.RestoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@AllArgsConstructor
public class RestoServiceImpl implements RestoService {

    private UserRepository userRepository;
    private RestaurantRepository restaurantReposetory;
    private final CuisineRepositiory cuisineRepository;
    private RestaurantMapper restaurantMapper;


    @Override
    public RestaurantResponse createRestaurant(long userId, RestaurantRequest restaurantRequest) {
        User user =userRepository.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("User Not Found , Invaild User Id"));

        if(user instanceof Admin admin){
            Restaurant restaurant = restaurantMapper.mapToRestaurantEntity(restaurantRequest);

            List<CuisineType> cuisineTypes = this.createNonExistingCuisineTypes(restaurant.getCuisineTypes());
            restaurant.setCuisineTypes(cuisineTypes);
            restaurant.setAdmin(admin);

            restaurantReposetory.save(restaurant);

            return restaurantMapper.mapToRestaurantResponse(restaurant);
        }
        else {
            try {
                throw new AccessDeniedException("unauthorized operation !!");
            } catch (AccessDeniedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private List<CuisineType> createNonExistingCuisineTypes(List<CuisineType> cuisineTypes) {
        return cuisineTypes.stream()
                .map(type -> cuisineRepository.findById(type.getCuisine())
                        .orElseGet(() -> {
                                    type.setCuisine(type.getCuisine().toLowerCase());
                                    return cuisineRepository.save(type);
                                }
                        ))
                .toList();
    }
}