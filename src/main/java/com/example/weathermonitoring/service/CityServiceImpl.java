package com.example.weathermonitoring.service;

import com.example.weathermonitoring.converter.CityResponseDtoConverter;
import com.example.weathermonitoring.model.dto.CityResponseDto;
import com.example.weathermonitoring.repository.CityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityServiceImpl implements CityService {

    CityRepository cityRepository;
    CityResponseDtoConverter cityResponseDtoConverter;

    @Override
    public List<CityResponseDto> getCities() {
        return cityResponseDtoConverter.convert(cityRepository.findAll());
    }

    @Override
    public CityResponseDto getById(Long id) {
        return cityResponseDtoConverter.convert(cityRepository.getById(id));
    }
}
