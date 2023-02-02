package com.task.attraction.service.attraction;

import com.task.attraction.entity.Attraction;
import com.task.attraction.entity.City;
import com.task.attraction.repository.AttractionRepository;
import com.task.attraction.service.AttractionService;
import com.task.attraction.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttractionServiceImp implements AttractionService {

    private final AttractionRepository attractionRepository;

    private final CityService cityService;


    @Override
    public List<Attraction> getAttraction(String typeFilter, Boolean nameSorted) {
        Stream<Attraction> stream = attractionRepository.findAll().stream();
        if (!Objects.isNull(typeFilter)) {
            stream = stream.filter(attraction -> typeFilter.equalsIgnoreCase(attraction.getType().name()));
        }
        if (!Objects.isNull(nameSorted) && nameSorted)
            stream = stream.sorted(Comparator.comparing(Attraction::getName).reversed());
        return stream.toList();
    }

    @Override
    public List<Attraction> getAttractionByCityName(String name) {
        City cityByName = cityService.findByName(name);
        return attractionRepository.findAll()
                .parallelStream()
                .filter(attraction -> attraction.getCityId().equals(cityByName.getId()))
                .toList();
    }

    @Override
    @Transactional
    public Attraction create(Attraction attraction) {
        Integer cityId = attraction.getCityId();
        City city = cityService.findById(cityId);
        attraction.setCityId(city.getId());
        return attractionRepository.save(attraction);
    }

    @Override
    @Transactional
    public Attraction updateDescription(Integer id, String description) {
        Attraction attraction = attractionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Сначало добавьти достопримечательность"));
        attraction.setDescription(description);
        return attraction;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        attractionRepository.deleteById(id);
    }

}
