package com.task.attraction.service;

import com.task.attraction.dto.AttractionDTO;
import com.task.attraction.entity.Attraction;

import java.util.List;

public interface AttractionService {

    List<Attraction> getAttraction(String typeFilter, Boolean nameSorted);

    List<Attraction> getAttractionByCityName(String name);

    Attraction create(AttractionDTO attractionDTO);

    Attraction updateDescription(Integer id, String description);

    void delete(Integer id);
}
