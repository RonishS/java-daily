package com.jdbc.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO student(name,college,gender,agree) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Ram");
            ps.setString(2, "KMC");
            ps.setString(3, "male");
            ps.setString(4, "yes");

            ps.executeUpdate();

            System.out.println("Data Inserted Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
