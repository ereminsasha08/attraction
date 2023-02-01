package com.task.attraction.repository;

import com.task.attraction.entity.Attraction;

import java.util.List;
import java.util.Optional;

public interface AttractionRepository {
    List<Attraction> findAll();

    Attraction save(Attraction attraction);

    Optional<Attraction> findById(Integer id);

    void deleteById(Integer id);
}

