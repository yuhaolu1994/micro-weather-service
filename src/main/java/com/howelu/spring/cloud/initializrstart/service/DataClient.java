package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.City;
import com.howelu.spring.cloud.initializrstart.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Data Client
 */
@Service
@FeignClient("msa-weather-eureka-client-zuul")
public interface DataClient {
    /**
     * Get City List
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * Get Weather Data By cityId
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
