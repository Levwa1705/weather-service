package com.example.weathermonitoring.converter;

import com.example.weathermonitoring.model.City;
import com.example.weathermonitoring.model.dto.CityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityResponseDtoConverter extends AbstractConverter<City, CityResponseDto> {

    @Override
    public void fill(City source, CityResponseDto target) {

        target.setName(source.getName());
        target.setCityId(source.getCityId());
    }
}
