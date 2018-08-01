package com.steven.hicks.logic.dao;

import com.steven.hicks.beans.Song;

import java.util.List;

public class SetQueryBuilder implements DAO
{
    private String name = "";
    private Integer encore;
    private List<Song> song;

    private SetQueryBuilder()
    {}

    public static class Builder
    {
        private String name = "";
        private Integer encore;
        private List<Song> song;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
