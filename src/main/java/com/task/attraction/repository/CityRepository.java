package com.task.attraction.repository;

import com.task.attraction.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    City save(City city);

   Optional<City> findById(Integer cityId);

    List<City> findAll();
}
