package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryList extends ItemList
{
    List<Country> countries;

    public List<Country> getCountries()
    {
        return countries;
    }

    public void setCountries(List<Country> countries)
    {
        this.countries = countries;
    }
}
