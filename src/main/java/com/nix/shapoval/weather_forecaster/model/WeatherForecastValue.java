package com.nix.shapoval.weather_forecaster.model;


import com.nix.shapoval.weather_forecaster.entity.WeatherForecast;

import java.time.LocalDate;

public class WeatherForecastValue {

    private Long id;
    private LocalDate date;
    private Double temperatureValue;

    public WeatherForecastValue(WeatherForecast weatherForecast) {
        this.id = weatherForecast.getId();
        this.date = weatherForecast.getDate();
        this.temperatureValue = weatherForecast.getTemperatureValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }
}
