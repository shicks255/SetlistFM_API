package com.steven.hicks;

import com.steven.hicks.beans.*;
import com.steven.hicks.logic.dao.*;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.CityQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
//        searchForArtist("owen");

//        searchForCity("New Jersey");

        searchForSetlists("73d49ab1");

//        searchForVenue("Rapids Theatre");
    }

    public static void searchForArtist(String artist)
    {
        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder()
                .artistName(artist)
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        searcher.search(builder, 1);

    }

    public static void searchForCity(String city)
    {
        CityQueryBuilder builder = new CityQueryBuilder.Builder()
            .state(city)
            .build();

        CitySearcher searcher = new CitySearcher();
        searcher.search(builder, 1);

    }

    public static void searchForSetlists(String venueId)
    {
        SetlistQueryBuilder builder = new SetlistQueryBuilder.Builder()
                .venueId(venueId)
                .build();

        SetlistSearcher searcher = new SetlistSearcher();
        searcher.search(builder, 1);
    }

    public static void searchForVenue(String venueName)
    {
        VenueQueryBuilder builder = new VenueQueryBuilder.Builder()
                .state("New Jersey")
//                .name(venueName)
                .build();

        VenueSearcher searcher = new VenueSearcher();
        searcher.searchAndGet(builder, 1);

    }

}
