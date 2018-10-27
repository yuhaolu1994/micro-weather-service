package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * City Client
 */
@Service
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
