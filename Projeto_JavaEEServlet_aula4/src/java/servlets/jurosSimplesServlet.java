/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioh
 */
@WebServlet(name = "jurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class jurosSimplesServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculo Juros Simples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculo do juros</h1>");
            try{
                double vlF;
                double vlP = Double.parseDouble(request.getParameter("vlP"));
                double juros = Double.parseDouble(request.getParameter("juros"));
                int tempo = Integer.parseInt(request.getParameter("tempo"));
                out.println("<h3>DADOS ENVIADOS</h3>");
                out.println("<h3>Valor atual: "+vlP+"</h3>");
                out.println("<h3>Juros Simples: "+juros+"</h3>");
                out.println("<h3>Tempo estimado: "+tempo+"</h3>");
                out.println("<hr>");
                vlF = vlP*(1+(juros/100)*tempo);
                out.println("<h3>O resultado ap??s "+tempo+" meses ??: "+vlF+"</h3>");
            }catch(Exception ex){
                out.println("<p style='color: red'>"+ex.getMessage()+"</p>");
            }
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.println("</body>");
            out.println("</html>");
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
