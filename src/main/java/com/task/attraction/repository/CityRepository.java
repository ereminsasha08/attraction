package com.task.attraction.repository;

import com.task.attraction.entity.City;

import java.util.List;

public interface CityRepository {
    List<City> findAll();
}
