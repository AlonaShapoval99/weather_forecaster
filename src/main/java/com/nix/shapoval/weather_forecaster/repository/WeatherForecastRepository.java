package com.nix.shapoval.weather_forecaster.repository;

import com.nix.shapoval.weather_forecaster.entity.WeatherForecast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WeatherForecastRepository extends MongoRepository<WeatherForecast, String> {
    WeatherForecast findByDate(LocalDate date);
}
