package com.steven.hicks.beans;

public class Song
{

    private String name = "";
    private Artist with;
    private Artist cover;
    private String info;
    private boolean tape;


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
