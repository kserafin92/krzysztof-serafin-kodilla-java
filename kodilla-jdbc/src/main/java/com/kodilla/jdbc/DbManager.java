package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {
    INSTANCE;


    private Connection conn;                                   // [2]

    DbManager() {
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/kodilla_curse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            conn = DriverManager.getConnection(jdbcUrl, "root", "Gotowery1");
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }                                                       // [15]

    public static DbManager getInstance() {                    // [16]
        return INSTANCE;                                        // [17]
    }                                                          // [18]

    public Connection getConnection() {                        // [19]
        return conn;                                            // [20]
    }                                                          // [21]
}