package com.example.weatherchecker.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<Weather> getWeathers() {
        System.out.println("BURADA: getWeathers() ");
        return weatherService.getWeathers();
    }

    @PostMapping
    public void registerNewWeather(@RequestBody Weather weather) {
        weatherService.addNewWeather(weather);
    }

    @DeleteMapping(path = "{weatherId}")
    public void deleteWeather(@PathVariable("weatherId") Long weatherId) {
        weatherService.deleteWeather(weatherId);
    }

    @PutMapping(path = "{weatherId}")
    public void updateWeather(@PathVariable("weatherId") Long weatherId,
                              @RequestParam(required = false) double degree,
                              @RequestParam(required = false) String weatherCond,
                              @RequestParam(required = false) String isGood,
                              @RequestParam(required = false) LocalDate date,
                              @RequestParam(required = false) String city) {
        weatherService.updateWeather(weatherId, degree, weatherCond, isGood, date, city);
    }
}
