package lab2;

import java.sql.*;

public class StudentSchema {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lab2db";
        String user = "root";
        String password = "";
        
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");
            Statement stmt = con.createStatement();
            
            System.out.println("\n1. Creating Student table WITHOUT email column...");
            // Task 1: Create table without email
            stmt.executeUpdate("CREATE TABLE Student (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "faculty VARCHAR(50), " +
                    "marks INT)");
            System.out.println("Table created successfully (no email column yet).");
            
            // Task 2: Alter table to add email
            System.out.println("\n2. Altering table to add email column...");
            int alterResult = stmt.executeUpdate("ALTER TABLE Student ADD COLUMN email VARCHAR(100)");
            System.out.println("Alter table completed. Rows affected: " + alterResult);
            
            // Task 3: Insert 5 records with affected rows
            System.out.println("\n3. Inserting 5 records...");
            String[] inserts = {
                "INSERT INTO Student (name, faculty, marks, email) VALUES ('Rajesh Sharma', 'Computer Science', 85, 'rajesh@example.com')",
                "INSERT INTO Student (name, faculty, marks, email) VALUES ('Priya Patel', 'Engineering', 78, 'priya@example.com')",
                "INSERT INTO Student (name, faculty, marks, email) VALUES ('Amit Kumar', 'Business', 92, 'amit@example.com')",
                "INSERT INTO Student (name, faculty, marks, email) VALUES ('Sneha Reddy', 'Science', 65, 'sneha@example.com')",
                "INSERT INTO Student (name, faculty, marks, email) VALUES ('Vikram Singh', 'Arts', 88, 'vikram@example.com')"
            };
            
            for (String insert : inserts) {
                int rows = stmt.executeUpdate(insert);
                System.out.println("  Inserted - Rows affected: " + rows);
            }
            System.out.println("Total: 5 students added");
            
            // Task 4: Show all
            System.out.println("\n4. All students:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") +
                        " - " + rs.getString("faculty") + " - " + rs.getInt("marks"));
            }
            
            // Task 5: Update marks with affected rows
            System.out.println("\n5. Updating Amit's marks to 95...");
            int updateRows = stmt.executeUpdate("UPDATE Student SET marks = 95 WHERE name = 'Amit Kumar'");
            System.out.println("Update completed. Rows affected: " + updateRows);
            
            // Task 6: Delete with affected rows
            System.out.println("\n6. Deleting Sneha Reddy...");
            int deleteRows = stmt.executeUpdate("DELETE FROM Student WHERE name = 'Sneha Reddy'");
            System.out.println("Delete completed. Rows affected: " + deleteRows);
            
            // Final list
            System.out.println("\n7. Final list:");
            rs = stmt.executeQuery("SELECT * FROM Student ORDER BY id");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") +
                        " - Marks: " + rs.getInt("marks"));
            }
            
            con.close();
            System.out.println("\nDone! All DDL/DML operations completed.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}