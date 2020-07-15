package com.nix.shapoval.weather_forecaster.model;


import com.nix.shapoval.weather_forecaster.entity.WeatherForecast;
import org.springframework.data.domain.Persistable;

import java.time.LocalDate;
import java.util.UUID;

public class WeatherForecastValue implements Persistable<UUID> {

    private UUID id;
    private LocalDate date;
    private Double temperatureValue;

    public WeatherForecastValue(WeatherForecast weatherForecast) {
        this.id = weatherForecast.getId();
        this.date = weatherForecast.getDate();
        this.temperatureValue = weatherForecast.getTemperatureValue();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
    @Override
    public boolean isNew() {
        return (getId() == null);
    }
}
