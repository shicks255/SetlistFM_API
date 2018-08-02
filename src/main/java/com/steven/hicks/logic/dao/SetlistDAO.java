package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.steven.hicks.beans.Setlist;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class SetlistDAO implements DAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public static List<Setlist>  search(SetlistQueryBuilder queryBuilder)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/setlists?");

        StringBuilder queryString = new StringBuilder();

        if (queryBuilder.getArtistMbid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistMbid=" + queryBuilder.getArtistMbid());
        }
        if (queryBuilder.getArtistName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistName=" + queryBuilder.getArtistName());
        }
        if (queryBuilder.getArtistTmid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistTmid=" + queryBuilder.getArtistTmid());
        }
        if (queryBuilder.getCityId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("cityId=" + queryBuilder.getCityId());
        }
        if (queryBuilder.getCityName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("cityName=" + queryBuilder.getCityName());
        }
        if (queryBuilder.getCountryCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("countryCode=" + queryBuilder.getCountryCode());
        }
        if (queryBuilder.getDate() != null)
        {
            //probably need a DatetimeFormatter here
            //:todo
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("date=" + queryBuilder.getDate());
        }
        if (queryBuilder.getLastUpdated() != null)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("lastUpdated=" + queryBuilder.getLastUpdated());
        }
        if (queryBuilder.getState().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("state=" + queryBuilder.getState());
        }
        if (queryBuilder.getStateCode().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("stateCode=" + queryBuilder.getStateCode());
        }
        if (queryBuilder.getTourName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("tourName=" + queryBuilder.getTourName());
        }
        if (queryBuilder.getVenueId().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("venueId=" + queryBuilder.getVenueId());
        }
        if (queryBuilder.getVenueName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("venueName=" + queryBuilder.getVenueName());
        }
        if (queryBuilder.getYear() != null)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("year=" + queryBuilder.getYear());
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

            JsonNode node = m_objectMapper.readTree(data.toString());
            JsonNode setlistsNode = node.get("setlist");

            CollectionType javaType = m_objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Setlist.class);

            m_objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            setlists = m_objectMapper.readValue(setlistsNode.toString(), javaType);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return setlists;
    }

}
