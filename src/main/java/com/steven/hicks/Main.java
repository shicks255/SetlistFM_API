package com.steven.hicks;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.logic.dao.ArtistDAO;

import java.util.List;

public class Main
{


    public static void main(String[] args)
    {
        List<Artist> artits = ArtistDAO.searchForArtists("afi");


        System.out.println(artits);
    }

}
