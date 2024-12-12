package com.weather.clients;

import com.weather.config.FaiegnConfiguration;
import com.weather.dtos.Weather;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface WeatherClient {

    @RequestLine("GET /data/2.5/weather?zip={zip}&appid={appid}")
    @Headers("Content-Type: application/json")
    Weather getWeather(@Param("zip") String zip, @Param("appid") String appid) throws Exception;
}
