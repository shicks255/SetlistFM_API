package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Song
{
    private String name = "";
    private Artist with;
    private Artist cover;
    private String info;
    private boolean tape;

    @Override
    public String toString()
    {
        return "Song - " + name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) &&
                Objects.equals(with, song.with);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, with);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Artist getWith()
    {
        return with;
    }

    public void setWith(Artist with)
    {
        this.with = with;
    }

    public Artist getCover()
    {
        return cover;
    }

    public void setCover(Artist cover)
    {
        this.cover = cover;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public boolean isTape()
    {
        return tape;
    }

    public void setTape(boolean tape)
    {
        this.tape = tape;
    }
}
