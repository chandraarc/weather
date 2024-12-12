package com.weather.dtos;

import lombok.Data;

import java.util.List;

@Data
public class Weather {
    Coord coord;
    List<WeatherDetails> weather;
    String base;
    MainDetails main;
    Long visibility;
    Wind wind;
    Clouds clouds;
    Long dt;
    Sys sys;
    Long timezone;
    Long id;
    String name;
    Integer cod;
}

