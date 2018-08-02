package com.steven.hicks.logic.deserializers;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate>
{
    public LocalDateDeserializer() {}

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext context)throws IOException
    {
        String date = jp.getText();
        try
        {
            return LocalDate.from(dtf.parse(date));
        }
        catch (DateTimeException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
