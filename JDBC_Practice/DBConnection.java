package com.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // 🔥 SINGLE RESPONSIBILITY:
    // Provide database connection

    public static Connection getConnection() {

        Connection con = null;

        try {
            // 🔥 LINE 1: Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 🔥 LINE 2: Create Connection
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/swingdb",
                "root",
                ""
            );

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
