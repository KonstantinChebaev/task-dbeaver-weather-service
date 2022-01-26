package com.taskdbeaverweahterservice.repository;

import com.taskdbeaverweahterservice.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {
    Optional<WeatherEntity> findByDate(LocalDate date);
}
