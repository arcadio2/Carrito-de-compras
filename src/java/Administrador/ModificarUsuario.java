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

public class ModificarUsuario extends HttpServlet {

    private Statement set;
    private ResultSet rs;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre, correo, contraseña, confirma;
            boolean valido = true;
            Metodos deseo = new Metodos();
            nombre = request.getParameter("nombre");
            correo = request.getParameter("correo");
            contraseña = request.getParameter("contraseña");
            confirma = request.getParameter("contraseña2");
            int id = Integer.parseInt(request.getParameter("id"));

            set = deseo.conecta().createStatement();

            if (nombre.length() < 1 || correo.length() < 1 || contraseña.length() < 1 || confirma.length() < 1) {
                if (contraseña != confirma) {
                    valido = false;
                    response.sendRedirect("ConsultaUsuarios.jsp");
                }
            }
            if (valido) {
                String q = "call ModificaUsuario('" + nombre + "','" + correo + "','" + contraseña + "'," + id + ");";
                set.execute(q);
                response.sendRedirect("ConsultaUsuarios.jsp");
            }

            response.sendRedirect("ConsultaUsuarios.jsp");
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
