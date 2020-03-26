<%-- 
    Document   : CrearUsuario
    Created on : 26/05/2019, 07:59:41 PM
    Author     : arcad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <script src="JS/jquery.js" charset="utf-8" type="text/javascript"> </script> 
         <script src="JS/Jquery-validate.js" charset="utf-8" type="text/javascript"> </script> 
         <script src="JS/add.js" charset="utf-8" type="text/javascript"> </script> 
         
          <%
           response.setHeader("Pragma", "no-cahce");
           response.addHeader("Cache-control", "must-revalidate");
           response.addHeader("Cache-control", "no-cache");
           response.addHeader("Cache-control", "no-store");
           response.setDateHeader("Expires", 0);
           if (session.getAttribute("username")==null) {
                   response.sendError(404);
               }else if(session.getAttribute("username")!=null){
                   int id_tus=(Integer) session.getAttribute("id_tus"); 
            if (id_tus!=1) {
                    response.sendError(404);
                }else if(id_tus==1){
                
            

        %>
        
        <h1>Agrega un trabajador</h1>
        <form action="" name="form" id="form"> 
            <label>Selecciona el tipo de trabajador</label>
            <select name="select">  <p id="a1"></p>
                <option>Selecciona una opcion--</option>
                <option>Panadero</option>
                <option>Cajero</option>
            </select>
            <br> <br> 
            <label>Nombre de usuario del trabajador:</label>
            <input type="text" name="username" id="username" autocomplete="off"> 
            <br> <br> 
            <label>Correo del trabajador:</label>
            <input type="text" name="email" id="email" autocomplete="off"> 
            <br> <br> 
            <label>Contraseña del trabajador:</label>
            <input type="password" name="password" id="password" autocomplete="off"> 
            <br> <br> 
            <label>Contraseña del administrador:</label>
            <input type="password" name="adminpass" id="adminpass" autocomplete="off"> 
            <br> <br> 
            <input type="submit" value="Registrar" name="send" id="send"> 
            
            <p id="avisos"> </p>
        </form> 
        
          <%}
        
        }%>
    </body>
</html>
