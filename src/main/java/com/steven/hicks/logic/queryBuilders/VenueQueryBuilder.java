package com.steven.hicks.logic.queryBuilders;

import com.steven.hicks.beans.City;

public class VenueQueryBuilder implements QueryBuilder
{
    private String cityId = "";
    private String cityName = "";
    private String countryName = "";
    private String state = "";
    private String stateCode = "";
    private String name = "";

    private VenueQueryBuilder()
    {}

    public static class Builder
    {
        private String cityId = "";
        private String cityName = "";
        private String countryName = "";
        private String state = "";
        private String stateCode = "";
        private String name = "";

        public Builder() {}

        public Builder cityId(String x)
        {
            this.cityId = x;
            return this;
        }

        public Builder cityName(String x)
        {
            this.cityName = x.replace(" ", "%20");
            return this;
        }

        public Builder countryName(String x)
        {
            this.countryName = x.replace(" ", "%20");
            return this;
        }

        public Builder name(String x)
        {
            this.name = x.replace(" ", "%20");
            return this;
        }

        public Builder state(String x)
        {
            this.state = x.replace(" ", "%20");
            return this;
        }

        public Builder stateCode(String x)
        {
            this.stateCode = x;
            return this;
        }

        public VenueQueryBuilder build()
        {
            VenueQueryBuilder queryBuilder = new VenueQueryBuilder();
            queryBuilder.setCityId(this.cityId);
            queryBuilder.setCityName(this.cityName);
            queryBuilder.setCountryName(this.countryName);
            queryBuilder.setName(this.name);
            queryBuilder.setState(this.state);
            queryBuilder.setStateCode(this.stateCode);

            return queryBuilder;
        }
    }

    public String getCityId()
    {
        return cityId;
    }

    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getStateCode()
    {
        return stateCode;
    }

    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
