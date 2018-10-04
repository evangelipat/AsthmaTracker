/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.db;

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
public class UserDB {

    public static void main(String args[]) throws ClassNotFoundException {
        boolean valid = true;
        String email = "evelinpats@gmail.com";
        Connection con;
        try {
            con = DBconnection.getConnection();
            Statement stm = con.createStatement();

            //   String query = "select * from users";
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM users ")
                    .append(" WHERE ").append(" EMAIL = ").append("'").append(email).append("';");

            //ResultSet rs = stm.executeQuery(query);
            stm.execute(query.toString());
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                String first = rs.getString("email");
                String second = rs.getString("password");
                String third = rs.getString("name");
                System.out.println("first->" + first + " ,second->" + second + ",third->" + third);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
