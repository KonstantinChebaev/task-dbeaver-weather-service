package com.taskdbeaverweahterservice.service;

import com.taskdbeaverweahterservice.WeatherEntity;

import java.util.Optional;

public interface WeatherService {

    Optional<WeatherEntity> getTodayWeather();
}
