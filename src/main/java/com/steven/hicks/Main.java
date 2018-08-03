package com.steven.hicks;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.Setlist;
import com.steven.hicks.logic.dao.*;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder().artistName("AFI").build();
        List<Artist> artists = ArtistDAO.search(builder);
//        System.out.println(artists);

        artists.removeIf(x -> !x.getName().equals("AFI"));

        Artist afi = ArtistDAO.getArtist(artists.get(0).getMbid());
        System.out.println(afi);


//        SetlistQueryBuilder builder = new SetlistQueryBuilder.Builder().artistName("afi")
//                .build();
//        List<Setlist> setlists = SetlistDAO.search(builder);


//        setlists.forEach(x -> System.out.println(x.toString()));

//        CityQueryBuilder builder = new CityQueryBuilder.Builder().name("Trenton").build();
//        List<City> cities = CityDAO.search(builder);
//
//        System.out.println(cities);
    }

}
