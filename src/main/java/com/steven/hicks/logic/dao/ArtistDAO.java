package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ArtistDAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

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

    public ArtistList search(ArtistQueryBuilder builder)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/artists?");

        StringBuilder queryString = new StringBuilder();

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

            JsonNode node = m_objectMapper.readTree(data.toString());
            JsonNode artistNodes = node.get("artist");

            list = m_objectMapper.readValue(data.toString(), ArtistList.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return list;
    }

}
