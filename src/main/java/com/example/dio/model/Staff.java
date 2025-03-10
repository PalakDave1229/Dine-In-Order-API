package com.example.dio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "staffs")
public class Staff extends User{

    @ManyToMany
    private List<RestaurantTable> restaurantTables;

    @ManyToOne
    private Restaurant restaurant;


}
