package com.steven.hicks.logic.queryBuilders;

public class CityQueryBuilder implements QueryBuilder
{
    private String id = "";
    private String country = "";
    private String name = "";
    private String state = "";
    private String stateCode = "";

    private CityQueryBuilder() {}

    public static class Builder
    {
        private String id = "";
        private String country = "";
        private String name = "";
        private String state = "";
        private String stateCode = "";

        public Builder() {}

        public Builder id(String x)
        {
            this.id = x;
            return this;
        }

        public Builder country(String x)
        {
            this.country = x.replace(" ", "%20");
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

        public CityQueryBuilder build()
        {
            CityQueryBuilder query = new CityQueryBuilder();
            query.country = this.country;
            query.name = this.name;
            query.state = this.state;
            query.stateCode = this.stateCode;

            return query;
        }
    }


    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
