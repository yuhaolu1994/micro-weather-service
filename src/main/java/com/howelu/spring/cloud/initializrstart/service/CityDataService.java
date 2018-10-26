package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.City;

import java.util.List;

/**
 * City Data Service Interface
 */
public interface CityDataService {

    /**
     * Get City List
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
