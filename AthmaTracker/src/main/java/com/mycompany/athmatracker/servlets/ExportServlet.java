/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.servlets;

import com.mycompany.athmatracker.db.LogbookDB;
import com.mycompany.athmatracker.model.Logbook;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eveli
 */
@WebServlet(name = "ExportServlet", urlPatterns = {"/ExportServlet"})
public class ExportServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email;
        try (PrintWriter out = response.getWriter()) {
            email = request.getSession().getAttribute("email").toString();

            List<Logbook> logbooks = new ArrayList<>();
            logbooks = LogbookDB.getLogbook(request.getSession().getAttribute("email").toString());

            FileWriter fileWriter = new FileWriter("C:/Users/eveli/Desktop/logbookData.txt");
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {

                printWriter.println("Logbook Data");

                for (int i = 0; i < logbooks.size(); i++) {
                    Logbook logbook = logbooks.get(i);

                    printWriter.println("Record created: " + logbook.getCreated());

                    if (!logbook.getAttack_date().isEmpty()) {

                        printWriter.print("Attack Date: " + logbook.getAttack_date() + " Duration: " + logbook.getAttack_duration() + " "
                                + logbook.getUnit() + " Triggers: " + logbook.getAttack_triggers() + "  ");
                    } else {
                        printWriter.print("Attack Date:  -    Duration: -   Triggers:  -   ");

                    }
                    if (!logbook.getPeakflow_date().isEmpty()) {
                        printWriter.println("Peak-Flow Date: " + logbook.getPeakflow_date() + " Value: " + logbook.getPeakflow_value() + " (l/min)" + "  ");
                    } else {
                        printWriter.println("Peak-Flow Date:  -    Value:  -   ");

                    }
                    printWriter.print("Symptoms: ");
                    if (logbook.getWheeze() == 1) {
                        printWriter.print("wheeze ");
                    }
                    if (logbook.getCough() == 1) {
                        printWriter.print("cough ");
                    }
                    if (logbook.getPhlegm() == 1) {
                        printWriter.print("plegm ");
                    }
                    if (logbook.getTightness() == 1) {
                        printWriter.print("chest tightness ");
                    }
                    if (logbook.getBreathing() == 1) {
                        printWriter.print("difficulty breathing ");
                    }
                    if (logbook.getWakeup() == 1) {
                        printWriter.print("symptoms wake me up at night or early morning ");
                    }
                    printWriter.println("");


                    if (!logbook.getNotes().isEmpty()) {
                        printWriter.print("Notes:" + logbook.getNotes());

                    }
                    printWriter.println("");
                    printWriter.println("");
                }

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
