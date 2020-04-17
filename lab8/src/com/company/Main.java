package com.company;

public class Main {
    Database dataB = new Database();
        dataB.DatabaseConnection("dba", "sql");

    AlbumController album = new AlbumController();
        album.setConn(dataB.getConn());
        album.create("This is my song", 1, 1500);
        System.out.println(album.findByArtist(543));

    ArtistController artist = new ArtistController();
        artist.setConn(dataB.getConn());
        artist.create("This is my song", "French");
        System.out.println(artist.findByName("This is my song"));
}