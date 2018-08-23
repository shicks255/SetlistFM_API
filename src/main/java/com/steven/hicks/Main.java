package com.steven.hicks;

import com.steven.hicks.beans.*;
import com.steven.hicks.logic.dao.*;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;

public class Main
{
    public static void main(String[] args)
    {

        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder()
                .artistName("Owen")
                .build();

        ArtistDAO dao = new ArtistDAO();


        ArtistList artistList = dao.search(builder);

        String test = "tes";

    }

}
