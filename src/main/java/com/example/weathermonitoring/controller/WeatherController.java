package com.example.weathermonitoring.controller;

import com.example.weathermonitoring.client.WeatherClient;
import com.example.weathermonitoring.model.dto.CityWeatherResponseDto;
import com.example.weathermonitoring.model.dto.WeatherResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WeatherController {
    WeatherClient weatherClient;

    @GetMapping
    public WeatherResponseDto getWeather(
            @RequestParam Long lat,
            @RequestParam Long lon,
            @RequestParam String appId,
            @RequestParam(required = false) String units
    ) {
        return weatherClient.getWeather(lat, lon, appId, units);
    }

    @GetMapping("/city")
    public CityWeatherResponseDto getCityWeather(
            @RequestParam String q,
            @RequestParam String appId
    ) {
        return weatherClient.getCityWeather(q, appId);
    }
}
