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
    private String cuisines;

    @ManyToMany(mappedBy = "cuisineTypes")
    private List<Restaurant> restaurants;
}
