package com.weather.dtos;

import lombok.Data;

@Data
public class WeatherResponse {
    private String weatherState;
    private String weatherDescription;
    private Float temparature;
    private Float minTemparature;
    private Float maxTemparature;
    private Float humidity;
    private String county;
    private Double longitude;
    private Double latitude;
    private String postalCode;
    private String user;
}
