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
//        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder().artistName("AFI").build();
//        List<Artist> artists = ArtistDAO.search(builder);
//        artists.removeIf(x -> !x.getName().equals("AFI"));
//        Artist afi = ArtistDAO.getArtist(artists.get(0).getMbid());
//        System.out.println(afi);


        SetlistQueryBuilder builder = new SetlistQueryBuilder.Builder().artistName("In Flames")
                .build();
        List<Setlist> setlists = SetlistDAO.search(builder);
//
//
        String test = "tesT";

//        setlists.forEach(x -> System.out.println(x.toString()));

//        CityQueryBuilder builder = new CityQueryBuilder.Builder().name("Trenton").build();
//        List<City> cities = CityDAO.search(builder);
//
//        System.out.println(cities);
//        Setlist setlist = SetlistDAO.getSetlist("63de4613");
//        System.out.println(setlist);

//        City city = CityDAO.getCity("5357527");
//        System.out.println(city);

//        VenueQueryBuilder venueBuilder = new VenueQueryBuilder.Builder().cityName("Trenton").build();
//        VenueDAO.search(venueBuilder);

//        Venue venue = VenueDAO.getVenue("6bd6ca6e");
//        System.out.println(venue);
    }

}
