package com.steven.hicks.logic.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>
{
    public LocalDateTimeDeserializer()
    {}

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext context) throws IOException
    {
        String dateTime = jp.getText();
        try
        {
            return LocalDateTime.from(dtf.parse(dateTime));
        }
        catch (DateTimeException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
