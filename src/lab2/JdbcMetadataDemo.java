package lab2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMetadataDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/lab2db";
        String user = "root";
        String password = "";

       
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            DatabaseMetaData metaData = con.getMetaData();

            System.out.println("Database Product Name : " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version : " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name : " + metaData.getDriverName());
            System.out.println("Driver Version : " + metaData.getDriverVersion());
            System.out.println("Logged-in User : " + metaData.getUserName());

            System.out.println("\nConnection established and closed successfully.");

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println("Error Message : " + e.getMessage());
        }
    }
}
