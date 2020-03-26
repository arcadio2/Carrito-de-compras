/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.*; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Iniciosesion extends HttpServlet {

 
 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try (PrintWriter out = response.getWriter()) {
           List<Usuario> lista=Conus.getAllUsuarios();
           boolean exist=false; 
           Usuario obj2=new Usuario(); 
           String nomusu, password; 
           nomusu=request.getParameter("nomusu");
           password=request.getParameter("pass");
           System.out.println(nomusu);
           for(Usuario a:lista){
               if (nomusu.equals(a.getUsername())) {
                   exist=true; 
                   System.out.println("holi");
               }
           }//fin foreach
           
           System.out.println(exist);
           if (exist==true) {
               System.out.println("si existe");
               obj2.setUsername(nomusu);
            Conus.getUsuarioByUsername(obj2);
            //aqui ps obtenemos los datos de la base jiji
            String comppass=Conus.getUsuarioByUsername(obj2).getPassword(); 
           System.out.println(comppass);
                if (password.equals(comppass)) {
                    int id_tus=Conus.getUsuarioByUsername(obj2).getId_tus();
                    int id=Conus.getUsuarioByUsername(obj2).getId();
                    int id_com=Conus.getUsuarioByUsername(obj2).getId_com();
                    System.out.println("son iguales");
                        if (id_tus==2) {
                            System.out.println("eres usuario");
                            //obtenemos la sesión
                            HttpSession sesion=request.getSession(true);
                            sesion.setAttribute("user", nomusu);
                            sesion.setAttribute("password", password);
                            sesion.setAttribute("Id", id);
                            sesion.setAttribute("Id_com", id_com);
                           //request.getRequestDispatcher("index.jsp").forward(request, response);
                           response.sendRedirect("index.jsp");
                        }else if(id_tus==1){
                            System.out.println("eres admin");
                           response.sendRedirect("indexadmin.jsp");
                        }else{
                            System.out.println("Error mijo, no existe el usuario");
                           
                            }//el else de los de tipo de usuario
                }else{
                    System.out.println("no son iguales");
                    
                     }//else donde se comparan  las contraseñas
           }else{
               System.out.println("no existe");
            
           }//else donde busca el usuario
           
          // System.out.println(Conus.getUsuarioByUsername(obj2).getUsername());
           
           
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Iniciosesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Iniciosesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
