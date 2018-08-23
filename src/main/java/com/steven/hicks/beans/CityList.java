package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityList extends ItemList
{
    List<City> cities;

    public List<City> getCities()
    {
        return cities;
    }

    public void setCities(List<City> cities)
    {
        this.cities = cities;
    }
}
