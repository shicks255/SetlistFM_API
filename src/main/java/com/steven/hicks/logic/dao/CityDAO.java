package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.steven.hicks.beans.City;
import com.steven.hicks.logic.queryBuilders.CityQueryBuilder;
import com.steven.hicks.logic.queryBuilders.QueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class CityDAO implements DAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

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

    public List<City> search(QueryBuilder queryBuilder)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/cities?");

        CityQueryBuilder cityQueryBuilder = (CityQueryBuilder)queryBuilder;

        StringBuilder queryString = new StringBuilder();

        if (cityQueryBuilder.getId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("id=?" + cityQueryBuilder.getId());
        }
        if (cityQueryBuilder.getName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("name=" + cityQueryBuilder.getName());
        }
        if (cityQueryBuilder.getState().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("state=" + cityQueryBuilder.getState());
        }
        if (cityQueryBuilder.getStateCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("stateCode=" + cityQueryBuilder.getStateCode());
        }
        if (cityQueryBuilder.getCountry().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("country=" + cityQueryBuilder.getCountry());
        }

        urlAddress.append(queryString);

        List<City> cities = null;
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

            JsonNode node = m_objectMapper.readTree(data.toString());
            JsonNode citiesNode = node.get("cities");

            CollectionType javaType = m_objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, City.class);

            cities = m_objectMapper.readValue(citiesNode.toString(), javaType);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return cities;
    }


}
