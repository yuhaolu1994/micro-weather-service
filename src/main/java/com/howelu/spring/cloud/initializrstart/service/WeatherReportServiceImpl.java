package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.Weather;
import com.howelu.spring.cloud.initializrstart.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Weather Report Service
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // provided by micro-weather-data-server
        WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);

        return resp.getData();
    }
}
