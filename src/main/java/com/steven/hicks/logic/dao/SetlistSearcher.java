package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.hicks.beans.Setlist;
import com.steven.hicks.beans.SetlistList;
import com.steven.hicks.logic.queryBuilders.QueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class SetlistSearcher implements Searchable<Setlist, SetlistList>
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public SetlistList m_setlistList;

    @Override
    public int getNumberOfPages()
    {
        return m_setlistList.getTotal() / m_setlistList.getItemsPerPage();
    }

    @Override
    public Setlist get(String id)
    {
        Setlist setlist = null;
        String urlAddress = "https://api.setlist.fm/rest/1.0/setlist/" + id;

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

            m_objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            setlist = m_objectMapper.readValue(data.toString(), Setlist.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return setlist;
    }

    @Override
    public void search(QueryBuilder queryBuilder, int pageNumber)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/setlists?");
        StringBuilder queryString = new StringBuilder();

        if (queryBuilder instanceof SetlistQueryBuilder == false)
        {
//            throw an exception here
        }

        SetlistQueryBuilder builder = (SetlistQueryBuilder)queryBuilder;

        if (builder.getArtistMbid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistMbid=" + builder.getArtistMbid());
        }
        if (builder.getArtistName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistName=" + builder.getArtistName());
        }
        if (builder.getArtistTmid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistTmid=" + builder.getArtistTmid());
        }
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
        if (builder.getCountryCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("countryCode=" + builder.getCountryCode());
        }
        if (builder.getDate() != null)
        {
            //probably need a DatetimeFormatter here
            //:todo
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("date=" + builder.getDate());
        }
        if (builder.getLastUpdated() != null)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("lastUpdated=" + builder.getLastUpdated());
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
        if (builder.getTourName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("tourName=" + builder.getTourName());
        }
        if (builder.getVenueId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("venueId=" + builder.getVenueId());
        }
        if (builder.getVenueName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("venueName=" + builder.getVenueName());
        }
        if (builder.getYear() != null)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("year=" + builder.getYear());
        }

        urlAddress.append(queryString);

        List<Setlist> setlists = null;
        try
        {
            URL url = new URL(urlAddress.toString());
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            connection.setRequestProperty("x-api-key", "692ab4ce-9835-4040-8bb8-d6bb77ba54f8");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestMethod("GET");

            StringBuilder data = new StringBuilder();
            String input2 = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((input2 = in.readLine()) != null)
                data.append(input2);

            m_setlistList = m_objectMapper.readValue(data.toString(), SetlistList.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean hasNextPage()
    {
        if (m_setlistList == null)
            return false;

        int setlistsSoFar = m_setlistList.getPage() * m_setlistList.getItemsPerPage();

        if (m_setlistList.getTotal() > setlistsSoFar)
            return true;

        return false;
    }

    @Override
    public SetlistList getNextPage(QueryBuilder queryBuilder)
    {
        int pageToGet = 1;
        if (m_setlistList != null)
            pageToGet = m_setlistList.getPage() + 1;

        return searchAndGet(queryBuilder, pageToGet);
    }

    @Override
    public SetlistList searchAndGet(QueryBuilder queryBuilder, int pageNumber)
    {
        search(queryBuilder, pageNumber);
        return m_setlistList;
    }

    @Override
    public SetlistList getSearchResults()
    {
        return m_setlistList;
    }

}
