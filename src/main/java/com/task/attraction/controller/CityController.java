package com.task.attraction.controller;

import com.task.attraction.entity.City;
import com.task.attraction.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CityController.REST_URL)
@RequiredArgsConstructor
public class CityController {
    public final static  String REST_URL = "rest/cityes";

    private final CityService cityService;

    @GetMapping
    public List<City> findAll(){
        return cityService.getAll();
    }
}
