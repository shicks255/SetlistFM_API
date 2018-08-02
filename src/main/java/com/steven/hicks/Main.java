package com.steven.hicks;

import com.steven.hicks.beans.Setlist;
import com.steven.hicks.logic.dao.*;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

//        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder().artistName("AFI").build();
//
//        List<Artist> artits = ArtistDAO.search(builder);
//        System.out.println(artits);

        SetlistQueryBuilder builder = new SetlistQueryBuilder.Builder().artistName("afi")
                .build();
        List<Setlist> setlists = SetlistDAO.search(builder);

        System.out.println(setlists);


//        CityQueryBuilder builder = new CityQueryBuilder.Builder().name("Trenton").build();
//        List<City> cities = CityDAO.search(builder);
//
//        System.out.println(cities);
    }

}
