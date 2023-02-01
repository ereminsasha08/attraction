package com.task.attraction.service.attraction;

import com.task.attraction.entity.Attraction;
import com.task.attraction.repository.AttractionRepository;
import com.task.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttractionServiceImp implements AttractionService {

    private final AttractionRepository attractionRepository;

    public List<Attraction> getAll(){
        return attractionRepository.findAll();
    }
}
