package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.hicks.beans.City;
import com.steven.hicks.beans.CityList;
import com.steven.hicks.logic.queryBuilders.CityQueryBuilder;
import com.steven.hicks.logic.queryBuilders.QueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CitySearcher implements Searchable<City, CityList>
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public CityList m_cityList;

    @Override
    public int getNumberOfPages()
    {
        return m_cityList.getTotal() / m_cityList.getItemsPerPage();
    }

    @Override
    public City get(String geoId)
    {
        City city = null;

        String urlAddress = "https://api.setlist.fm/rest/1.0/city/" + geoId;
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

            city = m_objectMapper.readValue(data.toString(), City.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return city;
    }

    @Override
    public void search(QueryBuilder queryBuilder, int pageNumber)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/cities?");
        StringBuilder queryString = new StringBuilder();

        if (queryBuilder instanceof CityQueryBuilder == false)
        {
            //throw an exception here
        }

        CityQueryBuilder builder = (CityQueryBuilder)queryBuilder;

        if (builder.getId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("id=?" + builder.getId());
        }
        if (builder.getName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("name=" + builder.getName());
        }
        if (builder.getState().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("state=" + builder.getState());
        }
        if (builder.getStateCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("stateCode=" + builder.getStateCode());
        }
        if (builder.getCountry().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("country=" + builder.getCountry());
        }
        if (queryString.length() > 0)
        {
            queryString.append("&p=" + pageNumber);
        }

        urlAddress.append(queryString);

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

            m_cityList = m_objectMapper.readValue(data.toString(), CityList.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean hasNextPage()
    {
        if (m_cityList == null)
            return false;

        int citiesSoFar = m_cityList.getPage() * m_cityList.getItemsPerPage();

        if (m_cityList.getTotal() > citiesSoFar)
            return true;

        return false;
    }

    @Override
    public CityList getNextPage(QueryBuilder queryBuilder)
    {
        int pageToGet = 1;
        if (m_cityList != null)
            pageToGet = m_cityList.getPage() + 1;

        return searchAndGet(queryBuilder, pageToGet);
    }

    @Override
    public CityList getSearchResults()
    {
        return m_cityList;
    }

    @Override
    public CityList searchAndGet(QueryBuilder queryBuilder, int pageNumber)
    {
        search(queryBuilder, pageNumber);
        return m_cityList;
    }


}
