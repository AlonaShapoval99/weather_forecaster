package com.nix.shapoval.weather_forecaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.nix.shapoval.weather_forecaster.service",
        "com.nix.shapoval.weather_forecaster.service.implementation",
        "com.nix.shapoval.weather_forecaster.controllers"})
@EntityScan(basePackages = {"com.nix.shapoval.weather_forecast.entity"})
public class WeatherForecasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherForecasterApplication.class, args);
    }

}
