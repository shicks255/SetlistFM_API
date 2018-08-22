package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.steven.hicks.beans.Venue;
import com.steven.hicks.logic.queryBuilders.QueryBuilder;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VenueDAO implements DAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public static Venue getVenue(String id)
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

    public List<Venue> search(QueryBuilder queryBuilder)
    {
        String urlAddress = "https://api.setlist.fm/rest/1.0/search/venues?";

        VenueQueryBuilder venueQueryBuilder = (VenueQueryBuilder)queryBuilder;

        StringBuilder query = new StringBuilder();

        if (venueQueryBuilder.getCityId().length() > 0)
        {
            if (query.length() > 0) query.append("&");
            query.append("cityId=" + venueQueryBuilder.getCityId());
        }

        if (venueQueryBuilder.getCityName().length() > 0)
        {
            if (query.length() > 0) query.append("&");
            query.append("cityName=" + venueQueryBuilder.getCityName());
        }

        if (venueQueryBuilder.getCountryName().length() > 0)
        {
            if (query.length() > 0) query.append("&");
            query.append("country=" + venueQueryBuilder.getCountryName());
        }

        if (venueQueryBuilder.getState().length() > 0)
        {
            if (query.length() > 0) query.append("&");
            query.append("state=" + venueQueryBuilder.getState());
        }

        if (venueQueryBuilder.getStateCode().length() > 0)
        {
            if (query.length() > 0) query.append("&");
            query.append("stateCode=" + venueQueryBuilder.getStateCode());
        }

        if (venueQueryBuilder.getName().length() > 0)
        {
            if (query.length() > 0) query.append("&");
            query.append("name=" + venueQueryBuilder.getName());
        }

        urlAddress += query.toString();

        List<Venue> venues = new ArrayList<>();

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

            JsonNode node = m_objectMapper.readTree(data.toString());
            JsonNode venueNode = node.get("venue");

            CollectionType javaType = m_objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Venue.class);

            m_objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            venues= m_objectMapper.readValue(venueNode.toString(), javaType);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return venues;
    }
}
