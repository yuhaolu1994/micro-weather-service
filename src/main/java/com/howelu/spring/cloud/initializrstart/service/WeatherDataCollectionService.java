package com.howelu.spring.cloud.initializrstart.service;

/**
 * Weather Data Collection Service
 */
public interface WeatherDataCollectionService {
    /**
     * Sync Weather By cityID
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
