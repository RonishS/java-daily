package lab2;

import java.sql.*;

public class ResultSetDemo {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/lab2db";
        String user = "root";
        String password = "";
        
        try {
            // 1. Connect to database
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            
            // 2. Create scrollable and updatable ResultSet
            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            
            System.out.println("Created scrollable/updatable ResultSet");
            
            // 3. Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student ORDER BY id");
            
            // Part A: Navigation
            System.out.println("\n=== Navigation Demo ===");
            
            // First row
            rs.first();
            System.out.println("First student: " + rs.getString("name"));
            
            // Last row
            rs.last();
            System.out.println("Last student: " + rs.getString("name"));
            
            // Absolute position
            rs.absolute(2);
            System.out.println("Student at row 2: " + rs.getString("name"));
            
            // Part B: Display all records
            System.out.println("\n=== All Students ===");
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                 ", Name: " + rs.getString("name") + 
                                 ", Marks: " + rs.getInt("marks"));
            }
            
            // Part C: Update record using ResultSet
            System.out.println("\n=== Updating Record ===");
            rs.absolute(1); // Go to first student
            int oldMarks = rs.getInt("marks");
            rs.updateInt("marks", 90);
            rs.updateRow();
            System.out.println("Updated " + rs.getString("name") + 
                             " marks from " + oldMarks + " to 90");
            
            // Part D: Insert new record using ResultSet
            System.out.println("\n=== Inserting New Record ===");
            rs.moveToInsertRow();
            rs.updateString("name", "Sunita Koirala");
            rs.updateString("faculty", "Science");
            rs.updateInt("marks", 82);
            rs.updateString("email", "sunita@example.com");
            rs.insertRow();
            System.out.println("Added new student: Sunita Koirala");
            
            // Part E: Delete record using ResultSet
            System.out.println("\n=== Deleting Record ===");
            // Find Priya Patel
            rs.beforeFirst();
            while(rs.next()) {
                if(rs.getString("name").equals("Priya Patel")) {
                    rs.deleteRow();
                    System.out.println("Deleted student: Priya Patel");
                    break;
                }
            }
            
            // Part F: Display final data
            System.out.println("\n=== Final Student List ===");
            rs = stmt.executeQuery("SELECT * FROM Student ORDER BY id");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + ". " + 
                                 rs.getString("name") + 
                                 " (" + rs.getString("faculty") + ") - " + 
                                 rs.getInt("marks"));
            }
            
            // Part G: Multiple queries
            System.out.println("\n=== Multiple Queries ===");
            
            System.out.println("Query 1: Students with marks > 85");
            ResultSet rs1 = stmt.executeQuery("SELECT name, marks FROM Student WHERE marks > 85");
            while(rs1.next()) {
                System.out.println("  " + rs1.getString("name") + " - " + rs1.getInt("marks"));
            }
            
            System.out.println("\nQuery 2: Computer Science students");
            ResultSet rs2 = stmt.executeQuery("SELECT name FROM Student WHERE faculty = 'Computer Science'");
            while(rs2.next()) {
                System.out.println("  " + rs2.getString("name"));
            }
            
            System.out.println("\nQuery 3: Count of students");
            ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) as total FROM Student");
            if(rs3.next()) {
                System.out.println("  Total students: " + rs3.getInt("total"));
            }
            
            // Close connection
            con.close();
            System.out.println("\nAll operations completed!");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}