package com.task.attraction.repository.postgres;

import com.task.attraction.entity.City;
import com.task.attraction.repository.CityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityPostgresRepository extends CityRepository, JpaRepository<City, Integer> {


}
