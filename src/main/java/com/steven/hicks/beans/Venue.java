package com.steven.hicks.beans;

import java.util.Objects;

public class Venue
{
    private City city;
    private String url = "";
    private String id = "";
    private String name = "";

    @Override
    public String toString()
    {
        return "Venue - " + name + " in " + city.getName() + " id" + id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(city, venue.city) &&
                Objects.equals(id, venue.id) &&
                Objects.equals(name, venue.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(city, id, name);
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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
