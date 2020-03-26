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
public class SAgregarCarro extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession sesion=request.getSession();
        Vector<Detalleventa> vectorDetalles=null;
        Vector<Producto> stockProducto=null;
        //Si se creo la sesion con el atributo de detalle de venta
        if(sesion.getAttribute("detalleVenta")!=null){
            //Si existe una sesion con ese atributo, se obtiene los datos de esa sesion
            vectorDetalles=(Vector<Detalleventa>)sesion.getAttribute("detalleVenta");
            stockProducto=(Vector<Producto>)sesion.getAttribute("stockProducto");
        }else{
            //Si no existe esa sesion se crea el vector de detalles de venta
            vectorDetalles=new Vector<Detalleventa>();
            stockProducto=new Vector<Producto>();

        }
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
        prod=prod.buscarProducto(codigo);
        if(prod.getProducto_stock()-cantidad <0){
        response.sendRedirect("AgregarProducto1.jsp");
        }else{
        double subTotal=cantidad * prod.getProducto_precio();
        //Creo el elemento Detalle de Venta
        Detalleventa detalle=new Detalleventa();
        boolean checar=false;
        
        for(Detalleventa dv : vectorDetalles){
            if (dv.getProducto_codigo()==codigo) {
                dv.setDetventa_subtotal(subTotal);
                dv.setDetventa_cantidad(cantidad);
                checar=true;
            }
            
        }
            if (checar==false) {
               detalle.setDetventa_item(vectorDetalles.size()+1);
        detalle.setProducto_codigo(codigo);
        detalle.setDetventa_subtotal(subTotal);
        detalle.setDetventa_cantidad(cantidad);
        vectorDetalles.add(detalle); 
            }
          
        sesion.setAttribute("detalleVenta",vectorDetalles);
        //Agegro el stock actualizado del producto
        prod.setProducto_stock(prod.getProducto_stock()-cantidad);
        stockProducto.add(prod);
        sesion.setAttribute("stockProducto", stockProducto);
        response.sendRedirect("MostrarCarrito.jsp");
        }
        }else{
           response.sendRedirect("AgregarProducto2.jsp?cod="+codigotxt);
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
