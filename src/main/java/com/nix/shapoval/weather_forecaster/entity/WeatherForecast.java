package com.nix.shapoval.weather_forecaster.entity;

import com.nix.shapoval.weather_forecaster.model.WeatherForecastValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "WeatherForecast")
public class WeatherForecast implements Persistable<UUID> {
    @Id
    private UUID  id;
    private LocalDate date;
    private Double temperatureValue;

    public WeatherForecast(WeatherForecastValue weatherForecastValue) {
        this.id = weatherForecastValue.getId();
        this.date = weatherForecastValue.getDate();
        this.temperatureValue = weatherForecastValue.getTemperatureValue();
    }

    public WeatherForecast(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
        this.date = LocalDate.now();
    }

    public WeatherForecast(UUID  id, Double temperatureValue) {
        this.id = id;
        this.date = LocalDate.now();
        this.temperatureValue = temperatureValue;
    }

    public WeatherForecast() {
    }

    public UUID  getId() {
        return id;
    }

    public void setId(UUID  id) {
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
