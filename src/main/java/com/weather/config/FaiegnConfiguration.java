package com.weather.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.clients.WeatherClient;
import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
@Import(FeignClientsConfiguration.class)
@Configuration
public class FaiegnConfiguration {
    @Value("${weather.url}")
    private String weatherURL;

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public WeatherClient weatherClient(Decoder feignDecoder) {
        WeatherClient fooClient = Feign.builder()
                .encoder(feignEncoder())
                .decoder(feignDecoder)
                .client(new OkHttpClient())
                .logger(new Slf4jLogger(WeatherClient.class))
                .logLevel(Logger.Level.FULL)
                .target(WeatherClient.class, weatherURL);
        return fooClient;
    }

    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(messageConverters);
    }

}
