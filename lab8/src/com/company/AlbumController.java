package com.company;
import java.sql.*;

public class AlbumController {
    Connection conn;
    Statement stmt = null;

    public void setConn(Connection conn){
        this.conn = conn;
    }

    public void create(String name, int artistId, int realeaseYear){
        String sql = "INSERT INTO ALBUMS (name, artist_id, release_year) VALUES ('" + name + "'," + artistId + ", " + realeaseYear +")";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    }

    public boolean findByArtist(int artistId){
        String sql = "SELECT id FROM ALBUMS where artist_id ="+ artistId;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            if (id != 0){
                return true;
            }
        }
    }

}