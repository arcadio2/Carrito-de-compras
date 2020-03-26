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
public class Modificiar extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String modnom = request.getParameter("cnom");
            String pass = request.getParameter("password");
            String apass = request.getParameter("apassword");
            String npass = request.getParameter("cpassword");
            HttpSession sesion = (HttpSession) request.getSession(); 
            int id = (Integer) sesion.getAttribute("id");
            String user = (String) sesion.getAttribute("username");
            if (modnom != null && pass != null) {
                if (Val.contraseñacorrecta(user, pass)) {
                    if (!Val.existeusuario(modnom)) {
                        if (Val.validarnombre(modnom)) {
                            EUsuario obj = new EUsuario(modnom, "", id);
                            ConexionUsuario.cambiar(obj);
                            sesion.removeAttribute("username");
                            sesion.setAttribute("username", modnom);
                            response.getWriter().print("1");
                        } else {
                            response.getWriter().print("Nombre invalido");
                        }
                    } else {
                        response.getWriter().print("Nombre de usuario existente");
                    }
                } else {
                    response.getWriter().print("contraseña incorrecta");
                }

            } else if (apass != null && npass != null) {
                System.out.println(npass);
                if (Val.contraseñacorrecta(user, apass)) {
                    if (Val.validarcontra(npass)) {
                        EUsuario obj = new EUsuario("", npass, id);
                        ConexionUsuario.cambiar(obj);
                        sesion.removeAttribute("password");
                        sesion.setAttribute("password", npass);
                        response.getWriter().print("1");
                    } else {
                        response.getWriter().print("contraseña inválida");
                    }
                } else {
                    response.getWriter().print("contraseña incorrecta");
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
