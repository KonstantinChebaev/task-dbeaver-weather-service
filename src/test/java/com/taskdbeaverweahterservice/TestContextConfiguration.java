package com.taskdbeaverweahterservice;

import com.taskdbeaverweahterservice.service.WeatherService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestContextConfiguration {

    @MockBean
    public WeatherService weatherService;
}
