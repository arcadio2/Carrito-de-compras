/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Controlador.Comunes;
import Controlador.Detalleventa;
import Controlador.Producto;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hwongu
 */
public class SAgregarPan extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession sesion=request.getSession();
        
        //Obtenemos los valores de la cajas de texto
        String codigotxt=request.getParameter("txtCodigo").trim();
        String cantidadtxt=request.getParameter("txtCantidadPedir").trim();
        boolean checartxt=false;
        if(Comunes.isNumeric(codigotxt)){
        checartxt=true;
        }else{
        checartxt=false;
        }
        if(Comunes.isNumeric(cantidadtxt)){
        checartxt=true;
        }else{
        checartxt=false;
        }
        if(checartxt==true){
        int codigo=Integer.parseInt(request.getParameter("txtCodigo").trim());
   
        int cantidad=Integer.parseInt(request.getParameter("txtCantidadPedir").trim());
        Producto prod=new Producto();
        int stock=prod.buscarProducto(codigo).getProducto_stock();
        stock= stock+cantidad;
        prod.actualizarStocksMas(stock, codigo);
        
       
        
        
        response.sendRedirect("Panadero.jsp?pan=1");
        
        }else{
           response.sendRedirect("Panadero.jsp?pan=1");
        }
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
