package com.task.attraction.controller;

import com.task.attraction.entity.City;
import com.task.attraction.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(CityController.REST_URL)
@RequiredArgsConstructor
public class CityController {
    public final static String REST_URL = "rest/cities";

    private final CityService cityService;

    @GetMapping
    public List<City> findAll() {
        return cityService.getAll();
    }

    @PostMapping
    public City add(@Valid @RequestBody City city) {
        return cityService.create(city);
    }

    @PatchMapping("update/{id}")
    public City update(@PathVariable Integer id,
                       @Nullable @RequestParam Integer population,
                       @Nullable @RequestParam Boolean underground) {
        return cityService.update(id, population, underground);
    }
}
