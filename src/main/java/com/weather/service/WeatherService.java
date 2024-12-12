package com.weather.service;

import com.weather.clients.WeatherClient;
import com.weather.config.ConfigurationData;
import com.weather.dtos.Weather;
import com.weather.dtos.WeatherRequest;
import com.weather.dtos.WeatherResponse;
import com.weather.jpa.WeatherRepository;
import com.weather.mappers.WeatherMapper;
import com.weather.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    ConfigurationData configurationData;

    @Autowired
    WeatherClient weatherClient;

    @Autowired
    WeatherMapper weatherMapper;

    @Autowired
    WeatherRepository weatherRepository;

    public WeatherResponse getWeatherReport(WeatherRequest request) throws Exception {
        Weather weather =  weatherClient.getWeather(request.getPostalCode(), configurationData.getWeatherReportAppId());
        WeatherResponse response = weatherMapper.map(weather);
        com.weather.entity.Weather entity = weatherMapper.map(response);
        entity.setPostalCode(request.getPostalCode());
        entity.setUser(SecurityConfig.getLoggedInUsername());
        weatherRepository.save(entity);
        return weatherMapper.map(entity);
    }

    public List<WeatherResponse> findByUser(String user){
       return weatherMapper.map(weatherRepository.findAllByUser(user));
    }

    public List<WeatherResponse> findByPostalCode(String code){
        return weatherMapper.map(weatherRepository.findAllByPostalCode(code));
    }

    public List<WeatherResponse> findByDetails(String code, String user){
        if(!user.isEmpty() && !code.isEmpty())
            return weatherMapper.map(weatherRepository.findAllByPostalCodeAndUser(code, user));

        return code.isEmpty() ? findByUser(user) : findByPostalCode(code);
    }


}
