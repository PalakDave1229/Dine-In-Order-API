package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {
    @Id

    private long restaurantId;

    private String name;

    private String address;

    private String contactNumber;

    private String contactEmail;

    private LocalTime opensAt;

    private LocalTime closesAt;

    private List<DietType> DietTypes;

    private LocalDate createdAt;

    private LocalDate lastModifiedAt;

    @ManyToMany(mappedBy = "restaurants", fetch = FetchType.EAGER)
    private List<cuisineType> cuisineType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

}