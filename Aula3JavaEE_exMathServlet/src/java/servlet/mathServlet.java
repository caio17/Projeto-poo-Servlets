/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
@WebServlet(name = "mathServlet", urlPatterns = {"/math.html"})
public class mathServlet extends HttpServlet {

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
            out.println("<title>MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculadora Basica</h1>");
            out.println("<form action='math.html'>Olá, preencha os valores e a operação desejada:</br>");
            out.println("<input type='number' name='n1' step='0.1'></br>");
            out.println("<input type='number' name='n2' step='0.1'></br>");
            out.println("<select name='opr'>");
            out.println("<option value='1'>SOMA</option>");
            out.println("<option value='2'>SUBTRAÇÃO</option>");
            out.println("<option value='3'>MULTIPLICAÇÃO</option>");
            out.println("<option value='4'>DIVISÃO</option>");
            out.println("</select>");
            out.println("<input type='submit' value='Calcular'></br>");
            try{
                int opr = Integer.parseInt(request.getParameter("opr"));
                double n1 = Double.parseDouble(request.getParameter("n1"));
                out.println("<h4><b>N1: </b>"+n1+"</h4>"); 
                double n2 = Double.parseDouble(request.getParameter("n2"));
                out.println("<h4><b>N2: </b>"+n2+"</h4>"); 
                out.println("<hr/>"); 
                switch (opr) {
                    case 1:
                        out.println("<h4><b>RESULTADO: </b>"+(n1+n2)+"</h4>");
                        break;
                    case 2:
                        out.println("<h4><b>RESULTADO: </b>"+(n1-n2)+"</h4>");
                        break;
                    case 3:
                        out.println("<h4><b>RESULTADO: </b>"+(n1*n2)+"</h4>");
                        break;
                    case 4:
                        out.println("<h4><b>RESULTADO: </b>"+(n1/n2)+"</h4>");
                        break;
                    default:
                        break;
                }
            }catch(Exception ex){
                out.println("<p style='color: red'>"+ex.getMessage()+"</p>");
            }
            out.println("</form>");
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
