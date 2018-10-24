/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.servlets;

import com.mycompany.athmatracker.db.LogbookDB;
import com.mycompany.athmatracker.model.Logbook;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "LogbookServlet", urlPatterns = {"/LogbookServlet"})
public class LogbookServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String email;
        try (PrintWriter out = response.getWriter()) {
            email = request.getSession().getAttribute("email").toString();
            String action = request.getParameter("action");

            if (action.equals("load")) {
                request.getRequestDispatcher("jsp/logbookPage.jsp").forward(request, response);
            } else if (action.equals("add")) {

                String attackDate = request.getParameter("attackDate");
                int attackDuration;
                String unit;
                String attackTriggers;
                String peakFlowDate = request.getParameter("peakFlowDate");
                int peakFlowValue;
                int wheeze = Integer.parseInt(request.getParameter("wheeze"));
                int cough = Integer.parseInt(request.getParameter("cough"));
                int phlegm = Integer.parseInt(request.getParameter("phlegm"));
                int tightness = Integer.parseInt(request.getParameter("tightness"));
                int breathing = Integer.parseInt(request.getParameter("breathing"));
                int wakeup = Integer.parseInt(request.getParameter("wakeup"));
                String notes = request.getParameter("notes");

                if ((attackDate == null || attackDate.trim().isEmpty())) {
                    attackDate = "";
                    attackDuration = 0;
                    unit = "";
                    attackTriggers = "";
                } else {
                    attackDuration = Integer.parseInt(request.getParameter("attackDuration"));
                    unit = request.getParameter("unit");
                    attackTriggers = request.getParameter("attackTriggers");
                }

                if ((peakFlowDate == null || peakFlowDate.trim().isEmpty())) {
                    peakFlowDate = "none";
                    peakFlowValue = 0;
                } else {
                    peakFlowValue = Integer.parseInt(request.getParameter("peakFlowValue"));
                }
                if ((notes == null || notes.trim().isEmpty())) {
                    notes = "";
                }

                Date dt = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String currentTime = sdf.format(dt);

                Logbook logbook = new Logbook(attackDate, attackDuration, unit, attackTriggers,
                        peakFlowDate, peakFlowValue,
                        wheeze, cough, phlegm, tightness, breathing, wakeup, notes, currentTime);

                LogbookDB.addRecord(email, logbook);
                response.setStatus(200);
                out.println("The record was added succesfully, please refresh your page!");

            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String notes = request.getParameter("notes");
                Logbook logbook = new Logbook();
                logbook.setId(id);
                logbook.setNotes(notes);
                LogbookDB.updateNotes(logbook);
                out.println("The record was updated succesfully, please refresh your page to load changes");

            } else {  //delete
                int id = Integer.parseInt(request.getParameter("id"));
                LogbookDB.deleteLog(id);
                System.out.println("ok!delete");
                response.setStatus(200);
                out.println("The record was deleted succesfully, please refresh your page to load changes");

            }

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogbookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogbookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogbookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogbookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
