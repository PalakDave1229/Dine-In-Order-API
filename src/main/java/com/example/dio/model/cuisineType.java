package com.example.dio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class cuisineType {
@Id
    private String cuisine;

@ManyToMany
    private Restaurant restaurant;
}
