package com.howelu.spring.cloud.initializrstart.service;

import com.howelu.spring.cloud.initializrstart.model.City;
import com.howelu.spring.cloud.initializrstart.model.CityList;
import com.howelu.spring.cloud.initializrstart.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * City Data Service
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        // read xml file
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line;

        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }

        br.close();

        // XML -> java Object
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
