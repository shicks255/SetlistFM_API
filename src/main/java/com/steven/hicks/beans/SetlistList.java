package com.steven.hicks.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetlistList extends ItemList
{
    List<Setlist> setlist;

    public List<Setlist> getSetlist()
    {
        return setlist;
    }

    public void setSetlist(List<Setlist> setlist)
    {
        this.setlist = setlist;
    }
}
