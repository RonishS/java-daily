package lab2;

import java.sql.*;
import java.util.Scanner;

public class StudentTransactions {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/lab2db";
        String user = "root";
        String password = "";
        
        Connection con = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            // 1. Connect to database
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            
            // 2. Disable auto-commit (start transaction)
            con.setAutoCommit(false);
            System.out.println("Auto-commit disabled - Transaction started");
            
            // 3. Create PreparedStatement
            String sql = "INSERT INTO Student (name, faculty, marks, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            System.out.println("\n=== Add Students ===");
            System.out.println("Enter student details (enter 'stop' for name to finish)");
            
            int count = 0;
            
            while(true) {
                System.out.println("\nStudent " + (count + 1) + ":");
                
                System.out.print("Name: ");
                String name = sc.nextLine();
                
                if(name.equalsIgnoreCase("stop")) {
                    break;
                }
                
                System.out.print("Faculty: ");
                String faculty = sc.nextLine();
                
                System.out.print("Marks: ");
                int marks = Integer.parseInt(sc.nextLine());
                
                System.out.print("Email: ");
                String email = sc.nextLine();
                
                // Set values in PreparedStatement
                pstmt.setString(1, name);
                pstmt.setString(2, faculty);
                pstmt.setInt(3, marks);
                pstmt.setString(4, email);
                
                // Execute insert
                pstmt.executeUpdate();
                count++;
                System.out.println("Added: " + name);
            }
            
            // Ask if user wants to simulate failure
            System.out.print("\nDo you want to simulate a failure? (yes/no): ");
            String choice = sc.nextLine();
            
            if(choice.equalsIgnoreCase("yes")) {
                // Simulate error
                System.out.println("Simulating database error...");
                throw new SQLException("Simulated transaction failure");
            }
            
            // Commit transaction
            con.commit();
            System.out.println("\nTransaction committed successfully!");
            System.out.println("Total students added: " + count);
            
            // Show current database state
            System.out.println("\nCurrent students in database:");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student ORDER BY id");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + ". " + 
                                 rs.getString("name") + " - " + 
                                 rs.getInt("marks"));
            }
            
        } catch (SQLException e) {
            System.out.println("\nError: " + e.getMessage());
            
            // Rollback transaction
            if(con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back!");
                    
                    // Show that no data was added
                    System.out.println("\nChecking database after rollback:");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM Student");
                    if(rs.next()) {
                        System.out.println("Total students: " + rs.getInt("total"));
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("Rollback failed: " + ex.getMessage());
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Clean up
            try {
                if(con != null) {
                    con.setAutoCommit(true); // Restore auto-commit
                    con.close();
                }
                sc.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection");
            }
        }
    }
}