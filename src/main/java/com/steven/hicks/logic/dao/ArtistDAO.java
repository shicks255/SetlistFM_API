package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.steven.hicks.beans.Artist;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class ArtistDAO implements DAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public static List<Artist> search(ArtistQueryBuilder queryBuilder)
    {
        StringBuilder urlAddress = new StringBuilder("https://api.setlist.fm/rest/1.0/search/artists?");

        StringBuilder queryString = new StringBuilder();

        if (queryBuilder.getArtistName().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistName=" + queryBuilder.getArtistName());
        }
        if (queryBuilder.getArtistMbid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistMbid=" + queryBuilder.getArtistMbid());
        }
        if (queryBuilder.getArtistTmid().length() > 0)
        {
            if (queryString.length() > 0) queryString.append("&");
            queryString.append("artistTmid=" + queryBuilder.getArtistTmid());
        }

        urlAddress.append(queryString);

        List<Artist> artists = null;
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

            CollectionType javaType = m_objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Artist.class);
            artists = m_objectMapper.readValue(artistNodes.toString(), javaType);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return artists;
    }

}
