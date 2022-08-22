package com.example.weathermonitoring.converter;

public interface WeatherFiller<S, T> {
    void fill(S source, T target);

    T createTarget ();
}
