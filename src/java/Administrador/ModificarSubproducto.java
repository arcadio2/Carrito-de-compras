
package Administrador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarSubproducto extends HttpServlet {

    private Statement set;
    private ResultSet rs;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int producto;
            String subproducto, url;
            boolean valido = true;
            Metodos deseo = new Metodos();
            subproducto = request.getParameter("subproducto");
            url = request.getParameter("url");
            int id = Integer.parseInt(request.getParameter("id"));
            
            set = deseo.conecta().createStatement();
            
            if (subproducto.length() < 1 || url.length() < 1) {
                valido = false;
                response.sendRedirect("ConsultaProductos.jsp");
            }
            if (valido) {
                String q = "call ModificaSubproducto('"+subproducto+"','"+url+"',"+id+");";
                set.execute(q);
                response.sendRedirect("ConsultaProductos.jsp");
            }
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
