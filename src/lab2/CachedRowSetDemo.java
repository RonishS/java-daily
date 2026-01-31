package lab2;

import java.sql.*;

public class CachedRowSetDemo {
    public static void main(String[] args) {
        
String url = "jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME";
String user = "YOUR_USERNAME";
String password = "YOUR_PASSWORD";;
        
        Connection con = null;
        
        try {
            // Part 1: Display current data
            System.out.println("=== Current Database Data ===");
            con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student ORDER BY id");
            System.out.println("ID\tName\t\t\tMarks");
            System.out.println("-----------------------------------");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                 rs.getString("name") + "\t\t" + 
                                 rs.getInt("marks"));
            }
            
            // Part 2: SQL Escape Syntax Examples
            System.out.println("\n=== SQL Escape Syntax ===");
            
            // Date function
            ResultSet dateRs = stmt.executeQuery("SELECT CURDATE() AS today_date");
            if(dateRs.next()) {
                System.out.println("Current date: " + dateRs.getDate("today_date"));
            }
            
            // Uppercase function
            ResultSet upperRs = stmt.executeQuery("SELECT UPPER(name) AS upper_name FROM Student WHERE id=1");
            if(upperRs.next()) {
                System.out.println("Uppercase of first student: " + upperRs.getString("upper_name"));
            }
            
            // Length function
            ResultSet lenRs = stmt.executeQuery("SELECT name, LENGTH(name) AS name_length FROM Student WHERE id=1");
            if(lenRs.next()) {
                System.out.println("Name length of " + lenRs.getString("name") + ": " + 
                                 lenRs.getInt("name_length") + " characters");
            }
            
            // Part 3: Close connection (simulate disconnected mode)
            System.out.println("\n=== Simulating Disconnected Mode ===");
            System.out.println("Closing database connection...");
            
            // Store data in arrays (simulating CachedRowSet)
            con.close();
            System.out.println("Connection closed. Working offline...");
            System.out.println("(In real CachedRowSet, we could modify data here)");
            
            // Part 4: Reconnect
            System.out.println("\nReconnecting to database...");
            con = DriverManager.getConnection(url, user, password);
            
            // Part 5: Generate and handle SQL exception
            System.out.println("\n=== Exception Handling Demo ===");
            
            try {
                // This will cause an SQL error
                System.out.println("Attempting to query non-existent table...");
                stmt = con.createStatement();
                stmt.executeQuery("SELECT * FROM TableDoesNotExist123");
                
            } catch (SQLException e) {
                System.out.println("SQL Exception Caught!");
                System.out.println("Error Message: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
            }
            
            // Part 6: Another exception - invalid SQL syntax
            System.out.println("\nTesting invalid SQL syntax...");
            try {
                stmt.executeQuery("SELECT FROM Student WHERE");
            } catch (SQLException e) {
                System.out.println("Syntax Error Caught!");
                System.out.println("Message: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
            }
            
            // Part 7: Valid operation after exception
            System.out.println("\n=== Valid Query After Exception ===");
            ResultSet finalRs = stmt.executeQuery("SELECT COUNT(*) as total FROM Student");
            if(finalRs.next()) {
                System.out.println("Total students in database: " + finalRs.getInt("total"));
            }
            
            System.out.println("\nAll tasks completed successfully!");
            
        } catch (SQLException e) {
            System.out.println("SQL Error occurred:");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection");
                }
            }
        }
    }
}
