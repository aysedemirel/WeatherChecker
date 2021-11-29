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
    private boolean isGood;
    private LocalDate dob;

    public Weather(Long id, double degree, String weather, boolean isGood, LocalDate date) {
        this.id = id;
        this.degree = degree;
        this.weather = weather;
        this.isGood = isGood;
        this.dob = date;
    }

    public Weather(double degree, String weather, boolean isGood, LocalDate date) {
        this.degree = degree;
        this.weather = weather;
        this.isGood = isGood;
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

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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
