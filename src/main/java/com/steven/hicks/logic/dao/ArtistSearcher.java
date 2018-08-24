package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.QueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ArtistSearcher implements Searchable<Artist, ArtistList>
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    private ArtistList m_artistList = new ArtistList();

    @Override
    public int getNumberOfPages()
    {
        return m_artistList.getTotal() / m_artistList.getItemsPerPage();
    }

    @Override
    public Artist get(String artistMbid)
    {
        Artist artist = null;
        String urlAddress = "https://api.setlist.fm/rest/1.0/artist/" + artistMbid;
        try
        {
            URL url = new URL(urlAddress);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            connection.setRequestProperty("x-api-key", "692ab4ce-9835-4040-8bb8-d6bb77ba54f8");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestMethod("GET");

            StringBuilder data = new StringBuilder();
            String input2 = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((input2 = in.readLine()) != null)
                data.append(input2);

            artist = m_objectMapper.readValue(data.toString(), Artist.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return artist;
    }

    @Override
    public boolean hasNextPage()
    {
        if (m_artistList == null)
            return false;

        int artistsSoFar = m_artistList.getPage() * m_artistList.getItemsPerPage();

        if (m_artistList.getTotal() > artistsSoFar)
            return true;

        return false;
    }

    @Override
    public ArtistList getNextPage(QueryBuilder queryBuilder)
    {
        int pageToGet = 1;
        if (m_artistList != null)
            pageToGet = m_artistList.getPage() + 1;

        return searchAndGet(queryBuilder, pageToGet);
    }

    @Override
    public void search(QueryBuilder queryBuilder, int pageNumber)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/artists?");
        StringBuilder queryString = new StringBuilder();

        try
        {
            if (queryBuilder instanceof ArtistQueryBuilder == false)
            {
                //log this
                throw new Exception("Wrong query builder passed in.");
            }
        }
        catch (Exception e)
        {
            //log
        }

        ArtistQueryBuilder builder = (ArtistQueryBuilder) queryBuilder;

        if (builder.getArtistName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistName=" + builder.getArtistName());
        }
        if (builder.getArtistMbid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistMbid=" + builder.getArtistMbid());
        }
        if (builder.getArtistTmid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistTmid=" + builder.getArtistTmid());
        }
        if (queryString.length() > 0)
        {
            queryString.append("&");
            queryString.append("p=" + pageNumber);
        }

        urlAddress.append(queryString);

        ArtistList list = null;
        try
        {
            URL url = new URL(urlAddress.toString());
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("x-api-key", "692ab4ce-9835-4040-8bb8-d6bb77ba54f8");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestMethod("GET");

            StringBuilder data = new StringBuilder();
            String input2 = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((input2 = in.readLine()) != null)
                data.append(input2);

            list = m_objectMapper.readValue(data.toString(), ArtistList.class);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        m_artistList = list;
    }

    @Override
    public ArtistList getSearchResults()
    {
        return m_artistList;
    }

    @Override
    public ArtistList searchAndGet(QueryBuilder queryBuilder, int pageNumber)
    {
        search(queryBuilder, pageNumber);
        return m_artistList;
    }
}
