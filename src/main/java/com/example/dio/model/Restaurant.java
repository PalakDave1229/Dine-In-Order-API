package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id

    private int restaurantId;

    private String name;

    private String address;

    private long contactNumber;

    private String contactEmail;

    private LocalTime opensAt;

    private LocalTime closesAt;

    private DietType DietType;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<cuisineType> cuisineType;
}