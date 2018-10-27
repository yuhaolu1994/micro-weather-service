package com.howelu.spring.cloud.initializrstart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * City Client
 */
@FeignClient("msa-weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
