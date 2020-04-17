package com.company;

import java.sql.*;

public class ArtistController implements DAOartist{
    Connection conn;
    Statement stmt = null;

    public void setConn(Connection conn){
        this.conn = conn;
    }

    public void create(String name, String country){
        String sql = "INSERT INTO ARTISTS (name, country) VALUES ('" + name + "', '" + country + "')";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    }

    public boolean findByName(String name){
        String sql = "SELECT id FROM ARTISTS WHERE name = '" + name +"'";
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