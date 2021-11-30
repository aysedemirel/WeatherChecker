package com.example.weatherchecker.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class WeatherConfig {

    CommandLineRunner commandLineRunner(WeatherRepository repository) {
        return args -> {
            Weather weatherMonday = new Weather(30.0, "sunny", WeatherStatus.GOOD, "Isparta",LocalDate.of(2021, Month.JULY, 23));
            repository.saveAll(List.of(weatherMonday));
        };
    }
}
