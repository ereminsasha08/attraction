package com.task.attraction.controller;

import com.task.attraction.entity.Attraction;
import com.task.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AttractionController.REST_URL)
@RequiredArgsConstructor
public class AttractionController {
    public final static String REST_URL = "rest/attractions";

    private final AttractionService attractionService;

    @GetMapping
    public List<Attraction> findAttraction(@Nullable @RequestParam String typeFilter,
                                           @Nullable @RequestParam Boolean nameSorted){
        return attractionService.getAttraction(typeFilter, nameSorted);
    }


}
