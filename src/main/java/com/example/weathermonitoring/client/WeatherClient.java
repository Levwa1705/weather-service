package com.example.weathermonitoring.client;

import com.example.weathermonitoring.model.dto.CityWeatherResponseDto;
import com.example.weathermonitoring.model.dto.WeatherResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${weather-client.name}", url = "${weather-client.url}")
public interface WeatherClient {

    @GetMapping
    WeatherResponseDto getWeather(
            @RequestParam Long lat,
            @RequestParam Long lon,
            @RequestParam String appId,
            @RequestParam(required = false) String units);

    @GetMapping()
    CityWeatherResponseDto getCityWeather(
            @RequestParam String q,
            @RequestParam String appId
    );
}
