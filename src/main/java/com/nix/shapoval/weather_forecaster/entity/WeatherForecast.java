package com.nix.shapoval.weather_forecaster.entity;

import com.nix.shapoval.weather_forecaster.model.WeatherForecastValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "WeatherForecast")
public class WeatherForecast {
    @Id
    private Long id;
    private LocalDate date;
    private Double temperatureValue;

    public WeatherForecast(WeatherForecastValue weatherForecastValue) {
        this.id = weatherForecastValue.getId();
        this.date = weatherForecastValue.getDate();
        this.temperatureValue = weatherForecastValue.getTemperatureValue();
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
