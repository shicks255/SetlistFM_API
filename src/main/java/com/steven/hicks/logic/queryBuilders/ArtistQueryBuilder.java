package com.steven.hicks.logic.queryBuilders;

public class ArtistQueryBuilder
{
    private String artistName = "";
    private String artistMbid = "";
    private String artistTmid = "";
    private String artistSor = "";

    private ArtistQueryBuilder()
    {}

    public static class Builder
    {
        private String artistName = "";
        private String artistMbid = "";
        private String artistTmid = "";
        private String artistSor = "";

        public Builder(){}

        public Builder artistName(String artistName)
        {
            this.artistName = artistName.replace(" ", "%20");
            return this;
        }

        public Builder mbId(String id)
        {
            this.artistMbid = id;
            return this;
        }

        public Builder tmId(String id)
        {
            this.artistTmid = id;
            return this;
        }


        public ArtistQueryBuilder build()
        {
            ArtistQueryBuilder query = new ArtistQueryBuilder();
            query.artistName = this.artistName;
            query.artistTmid = this.artistMbid;
            query.artistTmid = this.artistTmid;

            return query;
        }

    }

    public String getArtistName()
    {
        return artistName;
    }

    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }

    public String getArtistMbid()
    {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid)
    {
        this.artistMbid = artistMbid;
    }

    public String getArtistTmid()
    {
        return artistTmid;
    }

    public void setArtistTmid(String artistTmid)
    {
        this.artistTmid = artistTmid;
    }

    public String getArtistSor()
    {
        return artistSor;
    }

    public void setArtistSor(String artistSor)
    {
        this.artistSor = artistSor;
    }
}
