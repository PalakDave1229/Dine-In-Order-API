package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long restaurantId;

    private String name;

    private String address;

    private String contactNumber;

    private String contactEmail;

    private LocalTime opensAt;

    private LocalTime closesAt;

    @Enumerated(EnumType.STRING)
    private List<DietType> dietTypes;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CuisineType> cuisineTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantTable> restaurantTables;

    @OneToMany(mappedBy = "restaurant")
    private List<FoodItem> foodItems;

    @OneToMany(mappedBy = "restaurant")
    private List<Staff> staffs;

}