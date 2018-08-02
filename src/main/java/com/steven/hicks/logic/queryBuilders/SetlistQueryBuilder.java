package com.steven.hicks.logic.queryBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SetlistQueryBuilder
{
    String artistMbid = "";
    String artistName = "";
    String artistTmid = "";
    String cityId = "";
    String cityName = "";
    String countryCode = "";
    LocalDate date;
    LocalDateTime lastUpdated;
    String state = "";
    String stateCode = "";
    String tourName = "";
    String venueId = "";
    String venueName = "";
    Integer year;

    private SetlistQueryBuilder() {}

    public static class Builder
    {
        String artistMbid = "";
        String artistName = "";
        String artistTmid = "";
        String cityId = "";
        String cityName = "";
        String countryCode = "";
        LocalDate date;
        LocalDateTime lastUpdated;
        String state = "";
        String stateCode = "";
        String tourName = "";
        String venueId = "";
        String venueName = "";
        Integer year;

        public Builder artistMbid(String x)
        {
            this.artistMbid = x;
            return this;
        }

        public Builder artistName(String x)
        {
            this.artistName = x;
            return this;
        }

        public Builder artistTmid(String x)
        {
            this.artistTmid = x;
            return this;
        }

        public Builder cityId(String x)
        {
            this.cityId = x;
            return this;
        }

        public Builder cityName(String x)
        {
            this.cityName = x;
            return this;
        }

        public Builder countryCode(String x)
        {
            this.countryCode = x;
            return this;
        }

        public Builder date(LocalDate x)
        {
            this.date = x;
            return this;
        }

        public Builder lastUpdated(LocalDateTime x)
        {
            this.lastUpdated = x;
            return this;
        }

        public Builder state(String x)
        {
            this.state = x;
            return this;
        }

        public Builder stateCode(String x)
        {
            this.stateCode = x;
            return this;
        }

        public Builder tourName(String x)
        {
            this.tourName = x;
            return this;
        }

        public Builder venueId(String x)
        {
            this.venueId = x;
            return this;
        }

        public Builder venueName(String x)
        {
            this.venueName = x;
            return this;
        }

        public Builder year(Integer x)
        {
            this.year = x;
            return this;
        }

        public SetlistQueryBuilder build()
        {
            SetlistQueryBuilder query = new SetlistQueryBuilder();
            query.setArtistMbid(this.artistMbid);
            query.setArtistTmid(this.artistTmid);
            query.setArtistName(this.artistName);
            query.setCityId(this.cityId);
            query.setCityName(this.cityName);
            query.setCountryCode(this.countryCode);
            query.setDate(this.date);
            query.setLastUpdated(this.lastUpdated);
            query.setState(this.state);
            query.setStateCode(this.stateCode);
            query.setTourName(this.tourName);
            query.setVenueId(this.venueId);
            query.setVenueId(this.venueName);
            query.setYear(this.year);
            return query;
        }
    }


    public String getArtistMbid()
    {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid)
    {
        this.artistMbid = artistMbid;
    }

    public String getArtistName()
    {
        return artistName;
    }

    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }

    public String getArtistTmid()
    {
        return artistTmid;
    }

    public void setArtistTmid(String artistTmid)
    {
        this.artistTmid = artistTmid;
    }

    public String getCityId()
    {
        return cityId;
    }

    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalDateTime getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getStateCode()
    {
        return stateCode;
    }

    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getTourName()
    {
        return tourName;
    }

    public void setTourName(String tourName)
    {
        this.tourName = tourName;
    }

    public String getVenueId()
    {
        return venueId;
    }

    public void setVenueId(String venueId)
    {
        this.venueId = venueId;
    }

    public String getVenueName()
    {
        return venueName;
    }

    public void setVenueName(String venueName)
    {
        this.venueName = venueName;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }
}
