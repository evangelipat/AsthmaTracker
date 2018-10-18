/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.db;

import com.mycompany.athmatracker.model.Medication;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eveli
 */
public class MedicationDB {

    public static List<Medication> getMedications(String email) throws ClassNotFoundException, SQLException {

        List<Medication> medications = new ArrayList<>();

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM medications ")
                    .append(" WHERE ").append(" EMAIL = ").append("'").append(email).append("';");

            stm.execute(query.toString());
            ResultSet rs = stm.getResultSet();
            while (rs.next() == true) {
                Medication medication = new Medication();
                medication.setId(rs.getInt("id"));
                medication.setName(rs.getString("name"));
                medication.setDosage(rs.getInt("dosage"));
                System.out.println("DB: getMedications" + medication.getName());
                medications.add(medication);
            }

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return medications;
    }

    public static Medication getMedication(String email) throws ClassNotFoundException, SQLException {

        Medication medication = new Medication();
        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM medications ")
                    .append(" WHERE ").append(" EMAIL = ").append("'").append(email).append("';");

            stm.execute(query.toString());
            ResultSet rs = stm.getResultSet();
            if (rs.next()) {
                medication.setId(rs.getInt("id"));
                medication.setName(rs.getString("name"));
                medication.setDosage(rs.getInt("dosage"));
            }

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return medication;
    }

    public static void addMedication(String email, Medication medication) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO ")
                    .append(" medications (NAME, DOSAGE, EMAIL)")
                    .append(" VALUES (")
                    .append("'").append(medication.getName()).append("',")
                    .append("'").append(medication.getDosage()).append("',")
                    .append("'").append(email).append("');");

            stm.executeUpdate(query.toString());
            System.out.println("AsthmaTrackerDB::The medication was added with success");

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteMedication(Integer id) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("DELETE FROM medications ")
                    .append(" WHERE ")
                    .append(" id = ").append("'").append(id).append("';");


            stm.executeUpdate(query.toString());
            System.out.println("AsthmaTrackerDB::The medication was deleted with successfully");

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
