/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.db;

import com.mycompany.athmatracker.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eveli
 */
//TODO ADD, UPDATE, DELETE 
public class UserDB {

    /**
     * checks if the email exist, if it does then returns true else returns
     * false
     */
    public static boolean checkExistingEmail(String email) throws ClassNotFoundException {

        boolean valid = true;
        Connection connection;
        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM users ")
                    .append(" WHERE ").append(" EMAIL = ").append("'").append(email).append("';");

            stm.execute(query.toString());
            ResultSet rs = stm.getResultSet();
            if (rs.next()) {
                valid = true;
                System.out.println("AsthmaTrackerDB::The member already exist");
            } else {
                valid = false;
            }

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }

    public static User getUser(String email) throws ClassNotFoundException, SQLException {

        User user = new User();
        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM users ")
                    .append(" WHERE ").append(" EMAIL = ").append("'").append(email).append("';");

            stm.execute(query.toString());
            ResultSet rs = stm.getResultSet();
            if (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setBirth_date(rs.getString("birth_date"));
                user.setHeight(rs.getDouble("height"));
                user.setGender(rs.getInt("gender"));
            }

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
}
