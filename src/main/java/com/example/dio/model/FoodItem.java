package com.example.dio.model;

import com.example.dio.enums.DietType;
import com.example.dio.enums.StockStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "food_item", indexes = {@Index(name = "idx_name", columnList = "name")})
@EntityListeners(AuditingEntityListener.class)
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    private String description;

    private int stock;

    @Enumerated(EnumType.STRING)
    private StockStatus availability;

    @Enumerated(EnumType.STRING)
    private DietType dietType;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @ManyToOne
    private CuisineType cuisineType;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<Category> categories;
}
