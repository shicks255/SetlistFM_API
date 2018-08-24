package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueList extends ItemList
{
    List<Venue> venue;


    public List<Venue> getVenue()
    {
        return venue;
    }

    public void setVenue(List<Venue> venue)
    {
        this.venue = venue;
    }
}
