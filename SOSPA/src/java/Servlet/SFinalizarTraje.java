/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Controlador.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hwongu
 */
public class SFinalizarTraje extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session= request.getSession(true);
       
        
        int idCam= Integer.parseInt(request.getParameter("txtIdCamisa"));
        int idSac= Integer.parseInt(request.getParameter("txtIdSaco"));
        int idCor= Integer.parseInt(request.getParameter("txtIdCorbata"));
        int idPan= Integer.parseInt(request.getParameter("txtIdPantalon"));
        int idZap= Integer.parseInt(request.getParameter("txtIdZapato"));
        int idUs = (Integer) session.getAttribute("Id");
        
        String nomTra=request.getParameter("txtNomTra");
        Traje tra=new Traje();
        tra.registrarTraje(nomTra, idCam, idSac, idCor, idPan, idZap);
        System.out.println("Traje agregado");
        int idTra=tra.buscarTraje( idCam, idSac, idCor, idPan,nomTra,idZap).getTraje_id();
        System.out.println(idTra);
        tra.registrarTrajeGuardarropa(idUs, idTra);
        session.removeAttribute("MiCamisa");
        session.removeAttribute("MiSaco");
        session.removeAttribute("MiPantalon");
        session.removeAttribute("MiCorbata");
        session.removeAttribute("MiZapato");
        response.sendRedirect("MostrarTrajes.jsp");
        
        
      
        } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
