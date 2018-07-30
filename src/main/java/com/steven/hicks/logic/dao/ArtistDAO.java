package com.steven.hicks.logic.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.hicks.beans.Artist;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class ArtistDAO
{
    private static ObjectMapper m_objectMapper = new ObjectMapper();

    public static List<Artist> searchForArtists(String searchTerms)
    {

        List<Artist> artists = null;

        String urlAddress = "https://api.setlist.fm/rest/1.0/search/artists?artistName=" + searchTerms + "&p=1&sort=sortName";

        try
        {
            URL url = new URL(urlAddress);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("x-api-key", "692ab4ce-9835-4040-8bb8-d6bb77ba54f8");
//            connection.setRequestProperty("authority", "api.setlist.fm");
//            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("accept", "application/json");
//            connection.setRequestProperty("path", "/rest/1.0/search/artists?artistName=afi&p=1&sort=sortName");
//            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//            connection.setRequestProperty("Scheme", "https");
//            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.9,fr;q=0.8");
//            connection.setRequestProperty("cache-control", "max-age=0");
//            connection.setRequestProperty("upgrade-insecure-requests", "1");
//            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
//            connection.setRequestProperty("referer", "http://api.setlist.fm/docs/1.0/ui/index.html");
            connection.setRequestMethod("GET");

            StringBuilder data = new StringBuilder();
            String input2 = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((input2 = in.readLine()) != null)
            {
                System.out.println(input2);
                data.append(input2);
            }



            artists = m_objectMapper.readValue(connection.getURL(), new TypeReference<List<Artist>>(){});
        }
        catch (IOException e)
        {

        }

        return artists;
    }


}
