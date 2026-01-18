/* 
package DBtest;

import java.sql.*;

public class dbtesthaita {
    // Keep credentials at the top for easy modification
    private static final String URL = "jdbc:mysql://localhost:3306/YOUR_DB_NAME";
    private static final String USER = "YOUR_USERNAME";
    private static final String PASS = "YOUR_PASSWORD";

    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;

        try {
            // STEP 1: Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 2: Establish Connection
            con = DriverManager.getConnection(URL, USER, PASS);
            stm = con.createStatement();

            // STEP 3: Execute Queries (Uncomment the one you need)
            
            // --- INSERT ---
            // String sql = "INSERT INTO user(username, password) VALUES('admin', '1234')";
            // stm.executeUpdate(sql);

            // --- UPDATE ---
            // String sql = "UPDATE user SET password = 'newpassword' WHERE id = 1";
            // stm.executeUpdate(sql);

            // --- DELETE ---
            // String sql = "DELETE FROM user WHERE id = 3";
            // stm.executeUpdate(sql);

            // --- SELECT (Read) ---
            String sql = "SELECT * FROM user";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("username"));
            }

            System.out.println("Operation successful!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // STEP 4: Close Connections (Crucial for exams/best practice)
            try {
                if (stm != null) stm.close();
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
*/