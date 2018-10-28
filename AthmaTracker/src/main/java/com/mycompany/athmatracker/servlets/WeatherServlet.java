/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 *
 * @author eveli
 */
@WebServlet(name = "WeatherServlet", urlPatterns = {"/WeatherServlet"})
public class WeatherServlet extends HttpServlet {

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
            String city = request.getParameter("city");
            double temp;

            try {
                out.println("<div class=\"col-sm-12\" id=\"weather\"><br>");

                OWM owm = new OWM("943ed901c118ec454eaac8992da7b77b");
                CurrentWeather cwd = owm.currentWeatherByCityName(city);
                // checking data retrieval was successful or not
                if (cwd.hasCityName()) {
                    if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

                        /*      RAIN    ***/
                        if (cwd.hasRainData()) {
                            out.println("<img id=\"weatherIMG\" src=\"rain.jpeg\" alt=\"rain\" ><div class=\"weatherInfo\">");
                            out.println("<h2 id=\"city-temp\">" + city + "</h2><br>");

                            if (cwd.hasMainData() && cwd.getMainData().hasTemp()) {
                                temp = cwd.getMainData().getTemp();
                                temp = temp - 273.15;
                                /*Kelvin to Celcius*/
                                out.println("<h3 id=\"city-temp\">" + "Temperature:   " + temp + " °C" + "</h3>");
                            }
                            out.println("<h3 id=\"city-temp\">" + "Rain:   " + cwd.getRainData().getPrecipVol3h() + " mm" + "</h3>");
                            if (cwd.getMainData().hasHumidity()) {
                                out.println("<h3 id=\"city-temp\">" + "Humidity:   " + cwd.getMainData().getHumidity() + " %" + "</h3>");
                            }
                            out.println("<h3 id=\"city-temp\">" + "Wind:   " + cwd.getWindData().getSpeed() + " m/s" + "</h3>");
                            out.println("<h3 id=\"city-temp\">" + "Clouds:   " + cwd.getCloudData().getCloud() + " %" + "</h3></div>");

                        } else if (cwd.hasSnowData()) {
                            /*SNOW*/
                            out.println("<img id=\"weatherIMG\" src=\"snow.jpeg\" alt=\"snow\" ><div class=\"snow\">");
                            out.println("<h2 id=\"city-temp\">" + city + "</h2><br>");

                            if (cwd.hasMainData() && cwd.getMainData().hasTemp()) {
                                temp = cwd.getMainData().getTemp();
                                temp = temp - 273.15;
                                /*Kelvin to Celcius*/
                                out.println("<h3 id=\"city-temp\">" + "Temperature:   " + temp + " °C" + "</h3>");
                            }
                            out.println("<h3 id=\"city-temp\">" + "Snow:   " + cwd.getSnowData().getSnowVol3h() + " mm" + "</h3>");
                            out.println("<h3 id=\"city-temp\">" + "Wind:   " + cwd.getWindData().getSpeed() + " m/s" + "</h3>");
                            out.println("<h3 id=\"city-temp\">" + "Clouds:   " + cwd.getCloudData().getCloud() + " %" + "</h3></div>");
                        } else {
                            /*SUNNY WEATHER*/
                            out.println("<img id=\"weatherIMG\" src=\"sun.jpeg\" alt=\"sun\" ><div class=\"weatherInfo\">");
                            out.println("<h2 id=\"city-temp\">" + city + "</h2><br>");

                            if (cwd.hasMainData() && cwd.getMainData().hasTemp()) {
                                temp = cwd.getMainData().getTemp();
                                temp = temp - 273.15;
                                /*Kelvin to Celcius*/
                                out.println("<h3 id=\"city-temp\">" + "Temperature:   " + temp + " °C" + "</h3>");
                            }
                            if (cwd.getMainData().hasHumidity()) {
                                out.println("<h3 id=\"city-temp\">" + "Humidity:   " + cwd.getMainData().getHumidity() + " %" + "</h3>");
                            }
                            out.println("<h3 id=\"city-temp\">" + "Wind:   " + cwd.getWindData().getSpeed() + " m/s" + "</h3>");
                            out.println("<h3 id=\"city-temp\">" + "Clouds:   " + cwd.getCloudData().getCloud() + " %" + "</h3></div>");

                        }

                    } else {
                        out.println("<img id=\"weatherIMG\" src=\"no.jpeg\" alt=\"no\" ><div class=\"weatherInfo\">");
                        out.println("<h2 id=\"city-temp\">" + "There are no weather data, check connection " + "</h2><br></div>");
                    }
                } else {

                }
            } catch (APIException e) {
                System.out.println("Exception: " + e);
                out.println("<img id=\"weatherIMG\" src=\"no.jpeg\" alt=\"no\" ><div class=\"weatherInfo\">");
                out.println("<h2 id=\"city-temp\">" + "There are no weather data, whrong city name " + "</h2><br></div>");

            }
            out.println("</div>");

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
