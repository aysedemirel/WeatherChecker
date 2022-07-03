package com.example.weatherchecker.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeathers() {
        System.out.println("BURADA: ");
        return weatherRepository.findAll();
    }

    public void addNewWeather(Weather weather) {
        Optional<Weather> weatherOptional = weatherRepository.findWeatherByCity(weather.getCity());
        if (weatherOptional.isPresent()) {
            throw new IllegalStateException("date presented");
        }
        weatherRepository.save(weather);
    }

    public void deleteWeather(Long id)
    {
        boolean isExist = weatherRepository.existsById(id);
        if(!isExist)
        {
            throw new IllegalStateException("weather with id " + id+"does not exist");
        }
        weatherRepository.deleteById(id);
    }
    @Transactional
    public void updateWeather(Long id, double degree, String weatherCond, String isGood, LocalDate date, String city)
    {
        Weather weather = weatherRepository.findById(id).orElseThrow(() -> new IllegalStateException("weather with id " + id+"does not exist"));
        if(weatherCond != null && weatherCond.length() > 0 && !Objects.equals(weather.getWeather(), weatherCond));
        {
            weather.setWeather(weatherCond);
        }
        Optional<Weather> weatherOptional = weatherRepository.findWeatherByCity(city);
        if(weatherOptional.isPresent())
        {
            throw new IllegalStateException("weather presented");
        }
        weather.setDob(date);
    }
}
