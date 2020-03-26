/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Controlador.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arcad
 */
public class Modificarpass extends HttpServlet {

   
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
            HttpSession sesion= (HttpSession) request.getSession();
            String a=(String) sesion.getAttribute("password");
           int b=(int) sesion.getAttribute("Id");
           
           String oldpass=request.getParameter("apassword"); 
           String newpass=request.getParameter("cpassword");
            if (a.equals(oldpass)) {
                System.out.println("Si es la contra");
                Usuario obj=new Usuario();
                obj.setPassword(newpass);
                obj.setId(b);
                obj.setCorreo("");
                obj.setId_com(0);
                obj.setUsername("");
                Conus.Modificarusu(obj);
                sesion.removeAttribute("password");
                sesion.setAttribute("password", newpass);
                response.sendRedirect("Editar.jsp");
            }else{
                System.out.println("contraseña incorrecta");
            }
            
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
