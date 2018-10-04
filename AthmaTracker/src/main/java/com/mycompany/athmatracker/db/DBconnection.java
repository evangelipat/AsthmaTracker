/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eveli
 */
public class DBconnection {

    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/asthmatrackerdb", "root", "root");
    }
    /*   public DBconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asthmatrackerdb", "root", "root");
            stm = con.createStatement();

        } catch (Exception ex) {
            System.out.println("exception:" + ex);
        }
    }*/

 /*   public void getData() {
        try {

            String query = "select * from users";
            rs = stm.executeQuery(query);
            System.out.println("data from db");

            while (rs.next()) {
                String first = rs.getString("email");
                String second = rs.getString("password");
                String third = rs.getString("name");
                System.out.println("first->" + first + " ,second->" + second + ",third->" + third);

            }

        } catch (Exception ex) {
            System.out.println("exception" + ex);
        }
    }*/

}
