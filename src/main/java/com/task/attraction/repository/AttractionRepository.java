package com.task.attraction.repository;

import com.task.attraction.entity.Attraction;

import java.util.List;

public interface AttractionRepository {
    List<Attraction> findAll();
}
