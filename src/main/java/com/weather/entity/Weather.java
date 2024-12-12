package com.weather.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "weather")
@Data
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "weather_state")
    private String weatherState;

    @Column(name = "weather_description")
    private String weatherDescription;

    @Column(name = "temparature")
    private Float temparature;

    @Column(name = "min_temparature")
    private Float minTemparature;

    @Column(name = "max_temparature")
    private Float maxTemparature;

    @Column(name = "humidity")
    private Float humidity;

    @Column(name = "county")
    private String county;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "user")
    private String user;
}
