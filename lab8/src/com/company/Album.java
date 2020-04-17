package com.company;

public class Album {
    private int artistId;
    private String name;
    private int releaseYear;

    public Album(String name, int artistId, int releaseYear) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}