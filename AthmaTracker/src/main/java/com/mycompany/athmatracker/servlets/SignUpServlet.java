/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.servlets;

import com.mycompany.athmatracker.db.UserDB;
import com.mycompany.athmatracker.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eveli
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String birth_date = request.getParameter("birth_date");
            String gender = request.getParameter("gender");
            String text = "";
            text = checkFormat(email, password, firstname, lastname);

            boolean CheckIfEmpty = checkEmpty(email, password, firstname, lastname, birth_date);

            if (CheckIfEmpty) {

                out.println("Missing fields");
                response.setStatus(400);
                throw new Exception("Missing fields!");

            } else if (!text.isEmpty()) {

                out.println("Wrong Format: " + text);
                response.setStatus(400);

            } else {

                User user = new User(email, password, firstname, lastname, birth_date, gender);
                UserDB.addUser(user);
                session.setAttribute("email", email);      //session
                response.setStatus(200);
                request.getRequestDispatcher("/jsp/homePage.jsp").forward(request, response);
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

        } catch (Exception ex) {
            Logger.getLogger(SignUpServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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

        } catch (Exception ex) {
            Logger.getLogger(SignUpServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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

    public boolean checkEmpty(String email, String password, String firstname, String lastname, String birth_date) {
        if ((email == null || email.trim().isEmpty())
                || (password == null || password.trim().isEmpty())
                || (firstname == null || firstname.trim().isEmpty())
                || (lastname == null || lastname.trim().isEmpty())
                || (birth_date == null || birth_date.trim().isEmpty())) {
            return true;
        } else {
            return false;
        }

    }

    public String checkFormat(String email, String password, String firstname, String lastname) {
        String text = "";

        if (!email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$")) {
            text = text + "Email ";
        }
        if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{3,10}")) {
            text = text + "Password ";
        }
        if (!firstname.matches("[A-Za-z]{0,25}$")) {
            text = text + "Firstname ";
        }
        if (!lastname.matches("[A-Za-z]{0,25}$$")) {
            text = text + "Lastname ";
        }
        return text;
    }
}
