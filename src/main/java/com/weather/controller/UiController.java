package com.weather.controller;

import com.weather.security.SecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UiController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
    @GetMapping(value = "/homepage")
    public ModelAndView home() {
        return new ModelAndView("homepage", "role", SecurityConfig.getRole());
    }
}
