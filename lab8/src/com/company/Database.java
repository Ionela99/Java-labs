package com.company;

import java.sql.*;

public class Database {
    private static Connection con;
    public Connection getConnection() {
        return con;
    }
}
