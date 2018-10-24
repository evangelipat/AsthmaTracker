/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.db;

import com.mycompany.athmatracker.model.Logbook;
import com.mycompany.athmatracker.model.Medication;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eveli
 */
public class LogbookDB {

    public static void addRecord(String email, Logbook logbook) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO ")
                    .append(" logbook (EMAIL, ATTACK_DATE, ATTACK_DURATION, UNIT, "
                            + "ATTACK_TRIGGERS, PEAKFLOW_DATE, PEAKFLOW_VALUE, WHEEZE, COUGH, "
                            + "PHLEGM, TIGHTNESS, BREATHING, WAKEUP, "
                            + "NOTES, CREATED) ")
                    .append(" VALUES (")
                    .append("'").append(email).append("',")
                    .append("'").append(logbook.getAttack_date()).append("',")
                    .append("'").append(logbook.getAttack_duration()).append("',")
                    .append("'").append(logbook.getUnit()).append("',")
                    .append("'").append(logbook.getAttack_triggers()).append("',")
                    .append("'").append(logbook.getPeakflow_date()).append("',")
                    .append("'").append(logbook.getPeakflow_value()).append("',")
                    .append("'").append(logbook.getWheeze()).append("',")
                    .append("'").append(logbook.getCough()).append("',")
                    .append("'").append(logbook.getPhlegm()).append("',")
                    .append("'").append(logbook.getTightness()).append("',")
                    .append("'").append(logbook.getBreathing()).append("',")
                    .append("'").append(logbook.getWakeup()).append("',")
                    .append("'").append(logbook.getNotes()).append("',")
                    .append("'").append(logbook.getCreated()).append("');");

            stm.executeUpdate(query.toString());
            System.out.println("AsthmaTrackerDB::The logbook's record was added with success");

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Logbook> getLogbook(String email) throws ClassNotFoundException, SQLException {

        List<Logbook> logbooks = new ArrayList<>();

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM logbook ")
                    .append(" WHERE ").append(" EMAIL = ").append("'").append(email).append("';");

            stm.execute(query.toString());
            ResultSet rs = stm.getResultSet();
            while (rs.next() == true) {
                Logbook logbook = new Logbook();
                logbook.setId(rs.getInt("id"));
                logbook.setAttack_date(rs.getString("attack_date"));
                logbook.setAttack_duration(rs.getInt("attack_duration"));
                logbook.setUnit(rs.getString("unit"));
                logbook.setAttack_triggers(rs.getString("attack_triggers"));
                logbook.setPeakflow_date(rs.getString("peakflow_date"));
                logbook.setPeakflow_value(rs.getInt("peakflow_value"));
                logbook.setWheeze(rs.getInt("wheeze"));
                logbook.setCough(rs.getInt("cough"));
                logbook.setPhlegm(rs.getInt("phlegm"));
                logbook.setTightness(rs.getInt("tightness"));
                logbook.setBreathing(rs.getInt("breathing"));
                logbook.setWakeup(rs.getInt("wakeup"));
                logbook.setNotes(rs.getString("notes"));
                logbook.setCreated(rs.getString("created"));

                logbooks.add(logbook);
            }
            System.out.println("DB: getLogbook");
            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return logbooks;
    }

    public static void deleteLog(int id) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("DELETE FROM logbook")
                    .append(" WHERE ")
                    .append(" id = ").append("'").append(id).append("';");

            stm.executeUpdate(query.toString());
            System.out.println("AsthmaTrackerDB::The record was deleted with success");

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateNotes(Logbook logbook) throws ClassNotFoundException {

        Connection connection = null;

        try {
            connection = DBconnection.getConnection();
            Statement stm = connection.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("UPDATE logbook")
                    .append(" SET ")
                    .append(" NOTES = ").append("'").append(logbook.getNotes()).append("'")
                    .append(" WHERE ID = ").append("'").append(logbook.getId()).append("';");


            stm.executeUpdate(query.toString());
            System.out.println("AsthmaTrackerDB::The record was updated with success");

            stm.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
