package com.task.attraction.service;

import com.task.attraction.entity.City;

import java.util.List;

public interface CityService {
    City create(City city);

    List<City> getAll();

    City update(Integer id, Integer population, Boolean underground);

    City findById(Integer cityId);
}
