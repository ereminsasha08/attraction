package com.task.attraction.service.attraction;

import com.task.attraction.entity.Attraction;
import com.task.attraction.repository.AttractionRepository;
import com.task.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public List<Attraction> getAttraction(String typeFilter, Boolean nameSorted) {
        Stream<Attraction> stream = attractionRepository.findAll().stream();
        if (!Objects.isNull(typeFilter)) {
            stream = stream.filter(attraction -> typeFilter.equalsIgnoreCase(attraction.getType().name()));
        }
        if (!Objects.isNull(nameSorted) && nameSorted)
            stream = stream.sorted(Comparator.comparing(Attraction::getName));
        return stream.toList();
    }

    @Override
    public List<Attraction> getAttractionByCityName(String name) {
        return attractionRepository.findAll()
                .parallelStream()
                .filter(attraction -> name.equalsIgnoreCase(attraction.getCity().getName()))
                .toList();
    }

}
