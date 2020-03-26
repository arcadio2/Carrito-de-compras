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
public class CrearEmpleado extends HttpServlet {

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
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String tus = request.getParameter("select");
            String email = request.getParameter("email");
            String apass = request.getParameter("adminpass");
            HttpSession sesion = (HttpSession) request.getSession();
            String admin = sesion.getAttribute("password").toString();

            int id_tus = Val.obtenertus(tus);

            if (admin.equals(apass)) {
                if (Val.validarnullos(user, pass, email)) {
                    if (!Val.existeusuario(user) || !Val.existecorreo(email)) {
                        if (Val.validarnombre(user)) {
                            if (Val.validarcorreo(email)) {
                                if (Val.validarcontra(pass)) {
                                    if (id_tus == 3 || id_tus == 4) {
                                        EUsuario obj = new EUsuario(user, email, pass, id_tus);

                                        if (ConexionUsuario.RegistroEmpleado(obj)) {
                                            response.getWriter().print("1");
                                        } else {
                                            response.getWriter().print("Ocurrió un error");
                                        }
                                    } else {
                                        response.getWriter().print("Tipo de usuario no disponible");
                                    }
                                } else {
                                    response.getWriter().print("Contraseña invalida");
                                }
                            } else {
                                response.getWriter().print("Correo invalido");
                            }
                        } else {
                            response.getWriter().print("Nombre invalido");
                        }

                    } else {
                        response.getWriter().print("EL usuario o el correo ya existe");
                    }

                } else {
                    response.getWriter().print("No puedes dejar los campos nulos");
                }
            }else{
                response.getWriter().print("Contraseña de administrador incorrecta");
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
