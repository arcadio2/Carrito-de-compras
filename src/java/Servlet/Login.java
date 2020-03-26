/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;




import Controlador.ConexionUsuario;
import Controlador.EUsuario;
import Validar.Val;
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
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String username= request.getParameter("defaultLoginFormEmail");  
            String password = request.getParameter("defaultLoginFormPassword"); 
            EUsuario obj=new EUsuario(username); 
            String Correo=ConexionUsuario.getAllByUsername(obj).getCorreo();
            int id_us=ConexionUsuario.getAllByUsername(obj).getId(); 
            int id_tus=ConexionUsuario.getAllByUsername(obj).getId_tus(); 
            
            if (Val.existeusuario(username)) {
              //  response.getWriter().print("Has iniciado sesión");
                if (Val.contraseñacorrecta(username, password)) {
                    if (id_tus==1) {
                        response.getWriter().print("1");
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("id", id_us);
                    sesion.setAttribute("username", username);
                    sesion.setAttribute("password", password);
                    sesion.setAttribute("email", Correo);
                    sesion.setAttribute("id_tus", id_tus);
                    HttpSession sesionOk = request.getSession();
            sesionOk.setAttribute("usuario",username);
            sesionOk.setAttribute("id", id_us);
            
                    //response.sendRedirect("admin.jsp");
                    }else{
                       response.getWriter().print("2");
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("id", id_us);
                    sesion.setAttribute("username", username);
                    sesion.setAttribute("password", password);
                    sesion.setAttribute("email", Correo);
                    sesion.setAttribute("id_tus", id_tus);
                    HttpSession sesionOk = request.getSession();
            sesionOk.setAttribute("usuario",username);
            sesionOk.setAttribute("id", id_us);
                  // response.sendRedirect("Home.jsp");
                    }
                    
                    
                }else{
                    response.getWriter().print("3");
                }

            }else{
                response.getWriter().print("4");
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
