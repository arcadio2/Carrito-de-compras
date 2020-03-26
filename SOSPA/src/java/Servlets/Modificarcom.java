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
public class Modificarcom extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion= (HttpSession) request.getSession();
            int b=(int) sesion.getAttribute("Id");
            //int a=(int) sesion.getAttribute("Id_com");
            int id_com=0; 
           // System.out.println(a);
            String newcom=request.getParameter("newcom"); 
            String passu=(String) sesion.getAttribute("password");
           String oldpass=request.getParameter("apassword");
           
           
           if (newcom.equals("Ectomorfo")) {
                 id_com=1; 
             }else if(newcom.equals("Mesomorfo")){
                 id_com=2; 
             }else if(newcom.equals("Endomorfo")){ 
                 id_com=3; 
             }else{
                 System.out.println("no");
             }
            System.out.println(id_com);
            
            if (passu.equals(oldpass)) {
                System.out.println("contra correcta");
                Usuario obj=new Usuario();
                obj.setPassword("");
                obj.setId(b);
                obj.setCorreo("");
                obj.setId_com(id_com);
                obj.setUsername("");
                Conus.Modificarusu(obj);
                sesion.removeAttribute("Id_com");
                sesion.setAttribute("Id_com", id_com);
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
