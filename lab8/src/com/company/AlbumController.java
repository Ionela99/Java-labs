package com.company;

public class AlbumController {
    private String nume;
    private int ArtistId;
    private int ReleaseYear;

    public AlbumController(String name, int artistId, int releaseYear) {
        nume = name;
        ArtistId = artistId;
        ReleaseYear = releaseYear;
    }

    public String getmName() {
        return nume;
    }

    public int getmArtistId() {
        return ArtistId;
    }

    public int getmReleaseYear() {
        return ReleaseYear;
    }

}
