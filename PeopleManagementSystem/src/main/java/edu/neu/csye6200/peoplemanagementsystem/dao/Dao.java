package edu.neu.csye6200.peoplemanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Dao {

    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/employeemanagementsystem";
    static final String USER = "root";
    static final String PASS = "rootlol";

    static Connection conn;

    protected static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }


}
