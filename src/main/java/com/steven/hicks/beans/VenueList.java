package com.steven.hicks.beans;

import java.util.List;

public class VenueList extends ItemList
{
    List<Venue> venues;


    public List<Venue> getVenues()
    {
        return venues;
    }

    public void setVenues(List<Venue> venues)
    {
        this.venues = venues;
    }
}
