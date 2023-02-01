package com.task.attraction.controller;

import com.task.attraction.entity.Attraction;
import com.task.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AttractionController.REST_URL)
@RequiredArgsConstructor
public class AttractionController {
    public final static String REST_URL = "rest/attractions";

    private final AttractionService attractionService;

    @GetMapping
    public List<Attraction> findAll(){
        return attractionService.getAll();
    }


}
