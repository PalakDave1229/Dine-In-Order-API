package com.example.dio.model;

import com.example.dio.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "tables")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long tableNo;

    private long tableCapacity;

    private TableStatus status;

    @ManyToMany(mappedBy = "restaurantTables")
    private List<Staff> staffs;

    @ManyToOne
    private Restaurant restaurant;

}
