package com.howelu.spring.cloud.initializrstart.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.howelu.spring.cloud.initializrstart.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of weather data service interface
 */

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final long TIME_OUT = 1800L; // 1800s

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    /**
     * Get weather data from uri
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(@NotNull String uri) {
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;

        // check if data exist in cache
        if (stringRedisTemplate.hasKey(uri)) {
            logger.info("Redis has data");
            strBody = ops.get(uri);
        } else {
            logger.info("Redis does not have data");
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
            }

            // write to redis cache
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

        // use ObjectMapper, response json String -> weather Object
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error!", e);
        }

        return resp;
    }
}
