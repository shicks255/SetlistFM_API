package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistList extends ItemList
{
    List<Artist> artist;

    public List<Artist> getArtist()
    {
        return artist;
    }

    public void setArtist(List<Artist> artist)
    {
        this.artist = artist;
    }
}
