package com.example.dio.service.impl;

import com.example.dio.dto.request.TableRequest;
import com.example.dio.dto.response.TableResponse;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.TableMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Restaurant;
import com.example.dio.model.RestaurantTable;
import com.example.dio.model.User;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.repository.TableRepository;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TableServiceImpl implements TableService {

    private final RestaurantRepository restaurantRepository;
    private final TableMapper tableMapper;
    private final TableRepository tableRepository;

    @Override
    public TableResponse addTable(long restaurantId, TableRequest tableRequest) {
         RestaurantTable restaurantTable = tableMapper.mapToTabEntity(tableRequest);

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new UserNotFoundByIdException("Restaurant Not Found, Invalid User Id"));

        restaurantTable.setRestaurant(restaurant);
        tableRepository.save(restaurantTable);
        return tableMapper.mapToTabResponse(restaurantTable);



    }
}
