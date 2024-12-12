package com.weather.dtos;

import lombok.Data;
@Data
public class WeatherDetails{
   private Long id;
   private String main;
   private String description;
   private String icon;
}
