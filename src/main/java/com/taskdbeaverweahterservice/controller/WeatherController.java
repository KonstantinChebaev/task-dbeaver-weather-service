package com.taskdbeaverweahterservice.controller;

import com.taskdbeaverweahterservice.WeatherDto;
import com.taskdbeaverweahterservice.WeatherEntity;
import com.taskdbeaverweahterservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/get")
    public ResponseEntity<WeatherDto> getTodayWeather() {
        System.out.println("?? ???? ????? ???????");
        Optional<WeatherEntity> weatherEntity = weatherService.getTodayWeather();
        return weatherEntity.map(entity -> ResponseEntity.ok(new WeatherDto(entity.getWeather())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}