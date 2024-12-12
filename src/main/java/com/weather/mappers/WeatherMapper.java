package com.weather.mappers;

import com.weather.dtos.Weather;
import com.weather.dtos.WeatherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface WeatherMapper {
    @Mapping(target = "longitude", expression = "java(weatherData.getCoord().getLon())")
    @Mapping(target = "latitude", expression = "java(weatherData.getCoord().getLat())")
    @Mapping(target = "weatherState", expression ="java(weatherData.getWeather().get(0).getMain())")
    @Mapping(target = "weatherDescription",  expression ="java(weatherData.getWeather().get(0).getDescription())")
    @Mapping(target = "temparature", expression = "java(weatherData.getMain().getTemp())")
    @Mapping(target = "minTemparature", expression = "java(weatherData.getMain().getTemp_min())")
    @Mapping(target = "maxTemparature", expression = "java(weatherData.getMain().getTemp_max())")
    @Mapping(target = "humidity", expression = "java(weatherData.getMain().getHumidity())")
    @Mapping(target = "county", expression = "java(weatherData.getSys().getCountry())")
    WeatherResponse map(Weather weatherData);
    com.weather.entity.Weather map(WeatherResponse weather);
    WeatherResponse map(com.weather.entity.Weather weather);
    List<WeatherResponse> map(List<com.weather.entity.Weather> weathers);
}
