package com.steven.hicks.beans;

import java.util.Objects;


public class Artist
{
    private String mbid = "";

    private long tmid;
    private String name = "";
    private String searchName = "";
    private String disambiguation = "";
    private String url = "";

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(mbid, artist.mbid);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mbid);
    }

    @Override
    public String toString()
    {
        return "Artist - " + name + " id - " + mbid;
    }


    public String getMbid()
    {
        return mbid;
    }

    public void setMbid(String mbid)
    {
        this.mbid = mbid;
    }

    public long getTmid()
    {
        return tmid;
    }

    public void setTmid(long tmid)
    {
        this.tmid = tmid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSearchName()
    {
        return searchName;
    }

    public void setSearchName(String searchName)
    {
        this.searchName = searchName;
    }

    public String getDisambiguation()
    {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation)
    {
        this.disambiguation = disambiguation;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
