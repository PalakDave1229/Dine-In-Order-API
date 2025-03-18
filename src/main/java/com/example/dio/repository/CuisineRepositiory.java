package com.example.dio.repository;

import com.example.dio.model.CuisineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepositiory extends JpaRepository<CuisineType, String> {
}
