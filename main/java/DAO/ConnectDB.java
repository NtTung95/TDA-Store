package com.william;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
    public static String url = "jdbc:mysql://localhost/casestudy";
    public static String USER_NAME = "root";
    public static String PASSWORD = "tuananhdeptrai";
    public static Connection connectionDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}