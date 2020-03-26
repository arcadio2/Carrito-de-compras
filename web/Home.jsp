<%-- 
    Document   : Home
    Created on : 26/05/2019, 10:08:09 AM
    Author     : arcad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            response.setHeader("Pragma", "no-cahce");
            response.addHeader("Cache-control", "must-revalidate");
            response.addHeader("Cache-control", "no-cache");
            response.addHeader("Cache-control", "no-store");
            response.setDateHeader("Expires", 0);
             int id= (Integer) session.getAttribute("id_tus"); 
             System.out.println(id);
            
            if (session.getAttribute("username") == null) {
                response.sendRedirect("IniciarSesion.jsp");
            } else if (session.getAttribute("username") != null) {
                //int id= (Integer) session.getAttribute("id_tus");
                System.out.println(id + " usuairio");
                if (id==1) {
                        response.sendRedirect("admin.jsp");
                    }else if(id == 2){
                    
                response.sendRedirect("AgregarProducto1.jsp");

        %>
 
        
        <a href="CerrarSesion">Cerrar Sesión</a>
        <%}//fin del usuaerio normal
else if(id==3){
    response.sendRedirect("Panadero.jsp?pan=1");
        %>
        Aquí va todo lo del Panadero
        
            <a href="CerrarSesion">Cerrar Sesión</a>
<%}//fin del if del panadero%
else if(id==4){
response.sendRedirect("Cajero.jsp");
%>
   
    

<%}//fin del else del cajero
else{
response.sendError(404);
}%>
        <%}//fin del else de la sesion nula

        %>
    </body>
</html>
