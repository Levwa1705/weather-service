package com.example.weathermonitoring.controller;

import com.example.weathermonitoring.model.dto.CityResponseDto;
import com.example.weathermonitoring.service.CityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityController {
    CityService cityService;

    @GetMapping
    public List<CityResponseDto> getCities() {
        return cityService.getCities();
    }
    @GetMapping("/{id}")
    public CityResponseDto getById(@PathVariable  Long id){
        return cityService.getById(id);
    }
}
