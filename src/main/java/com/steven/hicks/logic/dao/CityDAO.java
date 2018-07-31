package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.steven.hicks.beans.City;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class CityDAO implements DAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public static List<City> search(CityQueryBuilder queryBuilder)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/cities?");

        StringBuilder queryString = new StringBuilder();

        if (queryBuilder.getId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("id=?" + queryBuilder.getId());
        }
        if (queryBuilder.getName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("name=" + queryBuilder.getName());
        }
        if (queryBuilder.getState().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("state=" + queryBuilder.getState());
        }
        if (queryBuilder.getStateCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("stateCode=" + queryBuilder.getStateCode());
        }
        if (queryBuilder.getCountry().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("?");
            queryString.append("country=" + queryBuilder.getCountry());
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
