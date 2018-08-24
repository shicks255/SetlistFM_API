package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.hicks.beans.Venue;
import com.steven.hicks.beans.VenueList;
import com.steven.hicks.logic.queryBuilders.QueryBuilder;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class VenueSearcher implements Searchable<Venue, VenueList>
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public VenueList m_venueList;

    @Override
    public int getNumberOfPages()
    {
        return m_venueList.getTotal() / m_venueList.getItemsPerPage();
    }

    @Override
    public Venue get(String id)
    {
        Venue venue = null;

        String urlAddress = "https://api.setlist.fm/rest/1.0/venue/" + id;

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

            venue = m_objectMapper.readValue(data.toString(), Venue.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return venue;
    }

    @Override
    public void search(QueryBuilder queryBuilder, int pageNumber)
    {
        String urlAddress = "https://api.setlist.fm/rest/1.0/search/venues?";
        StringBuilder queryString = new StringBuilder();

        if (queryBuilder instanceof VenueQueryBuilder == false)
        {
            //throw exception
        }

        VenueQueryBuilder builder = (VenueQueryBuilder)queryBuilder;

        if (builder.getCityId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("cityId=" + builder.getCityId());
        }

        if (builder.getCityName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("cityName=" + builder.getCityName());
        }

        if (builder.getCountryName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("country=" + builder.getCountryName());
        }

        if (builder.getState().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("state=" + builder.getState());
        }

        if (builder.getStateCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("stateCode=" + builder.getStateCode());
        }

        if (builder.getName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("name=" + builder.getName());
        }
        if (queryString.length() > 0)
        {
            queryString.append("&");
            queryString.append("p=" + pageNumber);
        }

        urlAddress += queryString.toString();

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

            m_venueList = m_objectMapper.readValue(data.toString(), VenueList.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean hasNextPage()
    {
        if (m_venueList == null)
            return false;

        int venuesSoFar = m_venueList.getPage() * m_venueList.getItemsPerPage();

        if (m_venueList.getTotal() > venuesSoFar)
            return true;

        return false;
    }

    @Override
    public VenueList getNextPage(QueryBuilder queryBuilder)
    {
        int pageToGet = 1;
        if (m_venueList != null)
            pageToGet = m_venueList.getPage() + 1;

        return searchAndGet(queryBuilder, pageToGet);
    }

    @Override
    public VenueList searchAndGet(QueryBuilder queryBuilder, int pageNumber)
    {
        search(queryBuilder, pageNumber);
        return m_venueList;
    }

    @Override
    public VenueList getSearchResults()
    {
        return m_venueList;
    }


}
