package com.example.weathermonitoring.service;

import com.example.weathermonitoring.model.dto.CityResponseDto;

import java.util.List;

public interface CityService {
   List<CityResponseDto> getCities();

   CityResponseDto getById(Long id);
}
