package com.steven.hicks;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.City;
import com.steven.hicks.beans.Setlist;
import com.steven.hicks.beans.Venue;
import com.steven.hicks.logic.dao.*;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.CityQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {

        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder()
                .artistName("American Football")
                .build();




    }

}
