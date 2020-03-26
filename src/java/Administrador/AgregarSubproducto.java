package Administrador;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarSubproducto extends HttpServlet {

    private Statement set;
    private ResultSet rs;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int producto, stock;
            double precio;
            String subproducto, url;
            boolean valido = true;
            Metodos deseo = new Metodos();
            producto = Integer.parseInt(request.getParameter("producto"));
            subproducto = request.getParameter("subproducto");
            url = request.getParameter("url");
            precio = Double.parseDouble(request.getParameter("precio"));
            stock = Integer.parseInt(request.getParameter("stock"));
            set = deseo.conecta().createStatement();
            
            if (producto == 0 || subproducto.length() < 1 || url.length() < 1 || precio < 1 || stock < 1) {
                valido = false;
                response.sendRedirect("AgregaSubproductos.jsp");
            }
            if (valido) {
                String q = "call InsertaSubproducto('"+subproducto+"',"+precio+","+stock+",'"+url+"',"+producto+");";
                set.execute(q);
                response.sendRedirect("AgregaSubproductos.jsp");
            }
            response.sendRedirect("AgregaSubproductos.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarSubproducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AgregarSubproducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AgregarSubproducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarSubproducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
