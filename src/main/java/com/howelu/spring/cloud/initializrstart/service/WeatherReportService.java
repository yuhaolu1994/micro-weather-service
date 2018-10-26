package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.Weather;

/**
 * Weather Report Service
 */
public interface WeatherReportService {
    /**
     * Search Weather Info by City ID
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
