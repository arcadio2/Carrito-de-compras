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

/**
 *
 * @author arcad
 */
public class CrearUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String rpassword = request.getParameter("rpaswword");

            EUsuario user = new EUsuario(username, email, password);
            ConexionUsuario a = new ConexionUsuario();

            if (!Val.validarnullos(username, password, email)) {
                response.getWriter().print("Dejaste nulos");
            } else {
                if (!Val.validarnombre(username)) {
                    response.getWriter().print("Nombre de usuario incorrecto");
                } else {
                    if (!Val.validarcorreo(email)) {
                        response.getWriter().print("Correo inválido");
                    } else {
                        if (!Val.validarcontra(password)) {
                            response.getWriter().print("Contraseña invalida");
                        } else {
                            if (Val.existeusuario(username) || Val.existecorreo(email)) {
                                response.getWriter().print("El Usuario o el Correo ya existe");
                            } else {
                                if (ConexionUsuario.RegistroUsuarios(user)) {
                                    response.getWriter().print("1");
                                    System.out.println("Usuario registrado");
                                } else {
                                    response.getWriter().print("Usuario no registrado");
                                    System.out.println("Usuario no registrado");
                                }
                            }

                        }

                    }

                }

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
