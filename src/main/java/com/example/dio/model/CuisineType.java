package com.example.dio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="CuisineType")
public class CuisineType {

    @Id
    @Column(name = "cuisine")
    private String cuisine;

    @ManyToMany(mappedBy = "cuisineTypes")
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "cuisineType")
    private List<FoodItem> foodItems;
}
