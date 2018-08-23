package com.steven.hicks;

import com.steven.hicks.beans.*;
import com.steven.hicks.logic.dao.*;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder()
                .artistName("Owen")
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        searcher.search(builder, 1);


        while (searcher.hasNextPage())
        {
            List<Artist> someArtists = searcher.getSearchResults().getArtist();

            someArtists.forEach(x -> System.out.println(x));
            searcher.getNextPage(builder);
        }


        System.out.println(searcher.getNumberOfPages());

    }

}
