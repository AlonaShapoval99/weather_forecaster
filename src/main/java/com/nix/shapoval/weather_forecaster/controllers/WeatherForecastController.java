package com.nix.shapoval.weather_forecaster.controllers;

import com.nix.shapoval.weather_forecaster.model.WeatherForecastValue;
import com.nix.shapoval.weather_forecaster.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weatherForecast")
public class WeatherForecastController {
    @Resource
    WeatherForecastService weatherForecastService;


    @CrossOrigin
    @GetMapping("/byDate")
    public WeatherForecastValue findByDate(@RequestParam String date) {
        return weatherForecastService.getForecastForDate(LocalDate.parse(date));
    }

}
