package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

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
}
