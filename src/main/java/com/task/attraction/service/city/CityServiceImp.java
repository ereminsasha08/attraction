package com.task.attraction.service.city;

import com.task.attraction.entity.City;
import com.task.attraction.repository.CityRepository;
import com.task.attraction.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImp implements CityService {

    private final CityRepository cityRepository;

    public List<City> getAll(){
        return cityRepository.findAll();
    }
}
