package com.example.weatherchecker.weather;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Weather {
    @Id
    @SequenceGenerator(
            name = "weather_sequence",
            sequenceName = "weather_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weather_sequence"
    )
    private Long id;
    private double degree;
    private String weather;
    private WeatherStatus isGood;
    private String city;
    private LocalDate dob;

    public Weather(Long id, double degree, String weather, WeatherStatus isGood, String city, LocalDate date) {
        this.id = id;
        this.degree = degree;
        this.weather = weather;
        this.isGood = isGood;
        this.city = city;
        this.dob = date;
    }

    public Weather(double degree, String weather, WeatherStatus isGood, String city, LocalDate date) {
        this.degree = degree;
        this.weather = weather;
        this.isGood = isGood;
        this.city = city;
        this.dob = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public WeatherStatus isGood() {
        return isGood;
    }

    public void setGood(WeatherStatus good) {
        isGood = good;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", weather='" + weather + '\'' +
                ", isGood=" + isGood +
                ", dob=" + dob +
                '}';
    }
}
