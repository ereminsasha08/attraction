package com.task.attraction.repository.postgres;

import com.task.attraction.entity.Attraction;
import com.task.attraction.repository.AttractionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AttractionRepositoryPostgres extends AttractionRepository, JpaRepository<Attraction, Integer> {

    @Modifying
    @Query("DELETE from Attraction c where c.id=:id")
    void deleteById(Integer id);

}
