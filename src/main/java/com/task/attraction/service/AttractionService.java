package com.task.attraction.service;

import com.task.attraction.entity.Attraction;

import java.util.List;

public interface AttractionService {

    List<Attraction> getAttraction(String typeFilter, Boolean nameSorted);
}
