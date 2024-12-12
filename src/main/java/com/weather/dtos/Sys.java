package com.weather.dtos;

import lombok.Data;

@Data
public class Sys{
    private Integer type;
    private Long id;
    private String country;
    private Long sunrise;
    private Long sunset;
}
