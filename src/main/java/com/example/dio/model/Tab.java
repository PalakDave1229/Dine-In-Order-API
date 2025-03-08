package com.example.dio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "tables")
public class Tab {
    @Id
    private int tableId;

    private int tableNo;

    private int tableCapacity;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;

}
