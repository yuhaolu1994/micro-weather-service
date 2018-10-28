package com.howelu.spring.cloud.initializrstart.controller;

import com.howelu.spring.cloud.initializrstart.model.City;
import com.howelu.spring.cloud.initializrstart.service.DataClient;
import com.howelu.spring.cloud.initializrstart.service.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Weather Report controller
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        List<City> cityList = null;

        try {
            // provided by msa-weather-city-server
            cityList = dataClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        model.addAttribute("title", "Your weather report");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
