package com.howelu.spring.cloud.initializrstart.job;

import com.howelu.spring.cloud.initializrstart.model.City;
import com.howelu.spring.cloud.initializrstart.service.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather Data Sync Job
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start!");

        // get city list id by CityDataService
        List<City> cityList = null;
        try {
            // TODO get data from cityDataService
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            cityList.add(city);
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        // iterate the city id list by WeatherDataCollectionService
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId: " + cityId);

            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End!");
    }
}
