package com.weather.dtos;

import lombok.Data;

@Data
public class MainDetails {
   private Float temp;
   private Float feels_like;
   private Float temp_min;
   private Float temp_max;
   private Float pressure;
   private Float humidity;
   private Float sea_level;
   private Float grnd_level;
}
