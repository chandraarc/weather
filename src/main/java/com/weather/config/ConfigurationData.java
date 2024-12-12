package com.weather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class ConfigurationData {
    @Value("${weather_report_app_id}")
    private String weatherReportAppId;

    @Value("${user1}")
    private String user1;

    @Value("${password1}")
    private String password1;

    @Value("${role1}")
    private String role1;

    @Value("${user2}")
    private String user2;

    @Value("${password2}")
    private String password2;

    @Value("${role1}")
    private String role2;
}
