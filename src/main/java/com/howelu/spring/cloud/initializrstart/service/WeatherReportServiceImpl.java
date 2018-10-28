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
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // provided by micro-weather-data-server
        WeatherResponse resp = dataClient.getDataByCityId(cityId);

        return resp.getData();
    }
}
