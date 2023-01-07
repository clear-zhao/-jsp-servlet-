package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBean {
    Connection connection=null;
    public Connection getconnection(){
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/user?serverTimezone=GMT%2B8"+"&useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="zkl20020118zkl";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

