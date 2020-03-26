package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controlador.*; 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Cerrarsesionusu extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
            
            HttpSession cerrar_sesion=request.getSession(); 
            cerrar_sesion.removeAttribute("user");
            cerrar_sesion.removeAttribute("password");
            cerrar_sesion.removeAttribute("Id");
            cerrar_sesion.removeAttribute("Id_com");
            cerrar_sesion.invalidate();
            
            response.sendRedirect("index.html");
        //    request.getRequestDispatcher("index.html").forward(request, response);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    \n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println("<title>Servlet Cerrarsesionusu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cerrarsesionusu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
