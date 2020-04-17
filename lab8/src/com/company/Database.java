package com.company;

import java.sql.*;
import java.sql.SQLException;
import java.lang.*;

public class Database {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "dba1";
    static final String PASS = "sql";

    Connection conn;
    Statement stmt = null;
   try{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();

        String tab = "create table artists(id integer not null generated always as identity (start with 1, increment by 1), name varchar(100) not null, country varchar(100), primary key (id));";
        String tab2 = "create table albums( id integer not null generated always as identity (start with 1, increment by 1), name varchar(100) not null, artist_id integer not null references artists on delete restrict, release_year integer, primary key (id));\n";

        stmt.executeUpdate(tab);
        stmt.executeUpdate(tab2);

    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){
        }
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}