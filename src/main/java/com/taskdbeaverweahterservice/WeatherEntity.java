package com.taskdbeaverweahterservice;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "weather_history")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "weather_date")
    private LocalDate date;

    @Column(name = "weather_value")
    private String weather;
}
