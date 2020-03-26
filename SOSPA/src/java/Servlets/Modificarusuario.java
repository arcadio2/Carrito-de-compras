package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controlador.*; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arcad
 */
public class Modificarusuario extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
          //  out.println(" <meta charset=\"UTF-8\">");
           
          
          //conectamos la sesión que teníamos
          HttpSession sesion= (HttpSession) request.getSession();
          
          //mandamos a llamar el nombre de usuario de la sesión y el id
           String a=(String) sesion.getAttribute("user");
           int b=(int) sesion.getAttribute("Id");
           //llamamos la password de la sesión
           String passuser=(String) sesion.getAttribute("password");
           //llamamos a nuestro arreglo de objetos que contiene todos los datos de la base para comparar si existe el nomusu
             List<Usuario> lista=Conus.getAllUsuarios();
             //una boleana para ver si existe el usuario xd
             boolean verusu=true; 
            
             //llamamos a los parametros del formulario
             String nomusu=request.getParameter("cnom"); 
             String password=request.getParameter("npassword");
             
             for(Usuario e:lista){
                if (nomusu.equals(e.getUsername())) {
                     verusu=false; 
                 }
             }//fin de for de buscar  si existe el usuario
             System.out.println(passuser);
             //comparamos las contras
             if (passuser.equals(password)) {
                 System.out.println("aqui entra");
                 //si entra comparamos vemos si es verdadero que puede tener ese username
                 if (verusu==true) {
                     System.out.println("Cambiado con exito");
                     Usuario obj=new Usuario();
                     obj.setUsername(nomusu);
                     obj.setId(b);
                     obj.setPassword("");
                     obj.setId_com(0); 
                     Conus.Modificarusu(obj); 
                     
                     sesion.removeAttribute("user");
                     sesion.setAttribute("user", nomusu);
                     response.sendRedirect("Editar.jsp");
                 }else{
                     System.out.println("Ya existe ese nombre de usuario");
                 }
                 
                 
            }else{
                 System.out.println("Contraseña incorrecta");
             }
             
             
             
             
             
             System.out.println(verusu);
             
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
