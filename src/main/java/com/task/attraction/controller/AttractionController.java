package com.task.attraction.controller;

import com.task.attraction.dto.AttractionDTO;
import com.task.attraction.entity.Attraction;
import com.task.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AttractionController.REST_URL)
@RequiredArgsConstructor
public class AttractionController {
    public final static String REST_URL = "rest/attractions";

    private final AttractionService attractionService;

    @GetMapping
    public List<Attraction> findAttraction(@Nullable @RequestParam String typeFilter,
                                           @Nullable @RequestParam Boolean nameSorted) {
        return attractionService.getAttraction(typeFilter, nameSorted);
    }

    @GetMapping("city/{name}")
    public List<Attraction> findByCityName(@PathVariable String name) {
        return attractionService.getAttractionByCityName(name);
    }

    @PostMapping
    public Attraction add(@Valid @RequestBody AttractionDTO attractionDTO) {
        return attractionService.create(attractionDTO);
    }

    @PatchMapping("update/{id}")
    public Attraction updateDescription(@PathVariable Integer id, @RequestParam String description) {
        return attractionService.updateDescription(id, description);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        attractionService.delete(id);
    }


}
