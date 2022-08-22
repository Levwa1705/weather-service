package com.example.weathermonitoring.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}

