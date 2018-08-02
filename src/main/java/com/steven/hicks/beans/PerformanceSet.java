package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PerformanceSet
{

    private String name = "";

    private Integer number;

    private Integer encore;

    List<PerformanceSet> set;

    List<Song> song;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public List<PerformanceSet> getSet()
    {
        return set;
    }

    public void setSet(List<PerformanceSet> set)
    {
        this.set = set;
    }

    public Integer getEncore()
    {
        return encore;
    }

    public void setEncore(Integer encore)
    {
        this.encore = encore;
    }

    public List<Song> getSong()
    {
        return song;
    }

    public void setSong(List<Song> song)
    {
        this.song = song;
    }
}
