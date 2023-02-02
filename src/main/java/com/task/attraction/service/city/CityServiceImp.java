package com.task.attraction.service.city;

import com.task.attraction.entity.City;
import com.task.attraction.repository.CityRepository;
import com.task.attraction.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImp implements CityService {

    private final CityRepository cityRepository;

    @Override
    @Transactional
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }


    @Override
    @Transactional
    public City update(Integer id, Integer population, Boolean underground) {
        City updateCity = findById(id);
        if (!Objects.isNull(population)) {
            updateCity.setPopulation(population);
        }
        if (!Objects.isNull(underground)) {
            updateCity.setUnderground(underground);
        }
        return updateCity;
    }

    @Override
    public City findById(Integer cityId) {
        return cityRepository.findById(cityId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Город не найден"));
    }
}
