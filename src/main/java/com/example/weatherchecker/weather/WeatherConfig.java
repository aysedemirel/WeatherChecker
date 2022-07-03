package com.example.weatherchecker.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class WeatherConfig {

    @Bean
    CommandLineRunner commandLineRunner(WeatherRepository repository) {
        return args -> {
            Weather weatherMonday = new Weather(30.0, "sunny", "Good", "Isparta",LocalDate.of(2021, Month.JULY, 23));
            Weather weatherSunday = new Weather(30.0, "sunny", "Good", "Ankara",LocalDate.of(2021, Month.JULY, 23));
             repository.saveAll(List.of(weatherMonday));
        };
    }
}
