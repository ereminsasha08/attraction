package com.task.attraction.repository.postgres;

import com.task.attraction.entity.Attraction;
import com.task.attraction.repository.AttractionRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface AttractionPostgresRepository extends AttractionRepository, JpaRepository<Attraction, Integer> {
    @EntityGraph(attributePaths = "city")
    List<Attraction> findAll();
}
