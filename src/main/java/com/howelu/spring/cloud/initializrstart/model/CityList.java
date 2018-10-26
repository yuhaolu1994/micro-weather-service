package com.howelu.spring.cloud.initializrstart.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * City List Data Model
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
