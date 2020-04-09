package com.company;

public class ArtistController {
    private String nume;
    private String tara;

    public ArtistController(String name, String country) {
        nume = name;
        tara = country;
    }

    public String getmCountry() {
        return tara;
    }

    public String getmName() {
        return nume;
    }
}
