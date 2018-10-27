package com.howelu.spring.cloud.initializrstart.controller;

import com.howelu.spring.cloud.initializrstart.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * City Controller
 */
public class CityController {
    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public String listCity() {
        // Search by Feign client
        String body = cityClient.listCity();
        return body;
    }
}
