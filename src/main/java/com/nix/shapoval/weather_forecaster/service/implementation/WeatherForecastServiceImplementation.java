package com.nix.shapoval.weather_forecaster.service.implementation;

import com.nix.shapoval.weather_forecaster.entity.WeatherForecast;
import com.nix.shapoval.weather_forecaster.model.WeatherForecastValue;
import com.nix.shapoval.weather_forecaster.process.OpenWeatherIntegration;
import com.nix.shapoval.weather_forecaster.repository.WeatherForecastRepository;
import com.nix.shapoval.weather_forecaster.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherForecastServiceImplementation implements WeatherForecastService {
    @Autowired
    private WeatherForecastRepository weatherForecastRepository;
    OpenWeatherIntegration openWeatherIntegration;
    @Override
    public List<WeatherForecastValue> getAllForecasts() {
        List<WeatherForecast> weatherForecasts = weatherForecastRepository.findAll();
        return weatherForecasts.stream()
                .map(WeatherForecastValue::new)
                .collect(Collectors.toList());
    }

    @Override
    public WeatherForecastValue getForecastForDate(LocalDate date) {

        openWeatherIntegration = new OpenWeatherIntegration();
        WeatherForecast weatherForecast = weatherForecastRepository.findByDate(date);
        return new WeatherForecastValue(weatherForecast);
    }


}
