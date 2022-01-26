package com.taskdbeaverweahterservice.service;

import com.taskdbeaverweahterservice.WeatherEntity;
import com.taskdbeaverweahterservice.repository.WeatherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;


@Log4j2
@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String DIV_WEATHER_TEMP = "<div class='weather__temp'>";
    private static final String WEATHER_SOURCE = "https://yandex.ru/";


    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public Optional<WeatherEntity> getTodayWeather() {
        LocalDate currentDate = LocalDate.now();
        Optional<WeatherEntity> todayWeather = weatherRepository.findByDate(currentDate);
        if(todayWeather.isEmpty()){
            try{
                Optional<String> optionalTemp = getTodayYandexWeather();
                if(optionalTemp.isEmpty()){
                    log.error("Cannot find weather temperature in [site = {}, div={}]", WEATHER_SOURCE, DIV_WEATHER_TEMP);
                    return Optional.empty();
                }
                WeatherEntity weatherEntity = new WeatherEntity()
                        .setWeather(optionalTemp.get())
                        .setDate(currentDate);
                weatherRepository.save(weatherEntity);
                todayWeather = Optional.of(weatherEntity);
            } catch (IOException e) {
                log.error("Exception has happened during searching weather in net [ex = {}]", e.getMessage());
                return Optional.empty();
            }
        }
        return todayWeather;
    }

    private Optional<String> getTodayYandexWeather() throws IOException {
        URL url = new URL(WEATHER_SOURCE);
        URLConnection con = url.openConnection();
        try (Scanner scanner = new Scanner(con.getInputStream());) {
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            int index = content.indexOf(DIV_WEATHER_TEMP);
            if(index == -1) {
                return Optional.empty();
            }
            return Optional.of(content.substring(index + 27, index + 30));
        }
    }
}