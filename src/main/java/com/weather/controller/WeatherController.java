package com.weather.controller;

import com.weather.dtos.Weather;
import com.weather.dtos.WeatherRequest;
import com.weather.dtos.WeatherResponse;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    WeatherService service;

    @RequestMapping(method = RequestMethod.POST, value = "/app/weather",  consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    WeatherResponse getWeather(@RequestBody WeatherRequest request) throws Exception {
        return service.getWeatherReport(request);
    }

    @RequestMapping(value = "/app/history",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<WeatherResponse> getWeather(@RequestParam(name = "postalCode", required = false) String postalCode,
                                    @RequestParam(name = "user", required = false) String user){
        return service.findByDetails(postalCode, user);
    }
}
