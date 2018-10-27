package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.WeatherResponse;

/**
 * Weather data service interface
 */
public interface WeatherDataService {
    /**
     * Fetch weather data by city id
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * Fetch weather data by city name
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
