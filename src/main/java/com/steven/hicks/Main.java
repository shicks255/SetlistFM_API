package com.steven.hicks;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.logic.dao.ArtistDAO;
import com.steven.hicks.logic.dao.ArtistQueryBuilder;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder().artistName("AFI").build();

        List<Artist> artits = ArtistDAO.search(builder);


        System.out.println(artits);
    }

}
