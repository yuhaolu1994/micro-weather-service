package com.howelu.spring.cloud.initializrstart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * City Client
 */
@Service
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
