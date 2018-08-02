package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.steven.hicks.logic.deserializers.LocalDateDeserializer;
import com.steven.hicks.logic.deserializers.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Setlist
{
    private String id = "";

    private Artist artist;

    private Venue venue;

    private List<PerformanceSet> sets;

    private String info = "";

    private String url = "";

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate eventDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastUpdated;




//Getters and setters
    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public Venue getVenue()
    {
        return venue;
    }

    public void setVenue(Venue venue)
    {
        this.venue = venue;
    }

    public List<PerformanceSet> getSets()
    {
        return sets;
    }

    public void setSets(List<PerformanceSet> sets)
    {
        this.sets = sets;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
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

    public LocalDate getEventDate()
    {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate)
    {
        this.eventDate = eventDate;
    }

    public LocalDateTime getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }
}
