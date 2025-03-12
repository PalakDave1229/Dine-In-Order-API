package com.example.dio.model;

import com.example.dio.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "RestaurantTable")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private long tableNo;

    private long tableCapacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @OneToMany(mappedBy = "restaurantTable")
    private List<CartItem> cartItems;

    @ManyToMany(mappedBy = "restaurantTables")
    private List<Staff> staffs;

    @ManyToOne
    private Restaurant restaurant;

}
