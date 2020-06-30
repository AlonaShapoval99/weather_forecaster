package com.nix.shapoval.weather_forecaster.service;

import com.nix.shapoval.weather_forecaster.model.WeatherForecastValue;

import java.time.LocalDate;
import java.util.List;

public interface WeatherForecastService {
    List<WeatherForecastValue> getAllForecasts();

    WeatherForecastValue getForecastForDate(LocalDate date);
}
