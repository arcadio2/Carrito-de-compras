<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Editar
    Created on : 25/04/2019, 04:41:55 PM
    Author     : arcad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page session="true"%>
<%
    //para eliminar el chaché
    
    /**response.setHeader("Pragma", "no-cahce");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    try{
    if(session.getAttribute("user")==null){
        request.getRequestDispatcher("indes.html").forward(request, response); 
    }
    }catch(Exception e){
         request.getRequestDispatcher("indes.html").forward(request, response);
    }*/
%>
<%
if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}

%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Datos del usuario</title>
    </head>
    <body>
        <h1>Aquí editas los datos</h1>
        Hola <%=session.getAttribute("user")%> <br> 
        De contraseña: <%=session.getAttribute("password")%>
        <br><br>
        <div> 
            Modificar nombre de usuario: <br><br>
        <form action="Modificarusuario" name="modnom" method="post" onsubmit="return moduser()">
            <div> 
                Escribe el nuevo nombre de usuario:
                <input type="text" name="cnom">  
            </div>
            <br>
            <div> 
                Escribe tu contraseña: 
                <input type="password" name="password"> 
            </div>
            <div><p id="error">  </p> </div>
            <div> 
                <input type="submit" name="envcnom">  
            </div>
                       
        </form>
        </div>
         <br> <br> 
        <div> 
            Modificar contraseña: <br><br>
            <form action="Modificarpass" method="post" name="mpass" onsubmit="return modpass()">
                <div> 
                    Escribe tu nueva contraseña: 
                    <input type="password" name="cpassword">
                </div>
                <br>
                <div>
                    Verifica tu contraseña:
                    <input type="password" name="apassword"> 
                </div>
                <div><p id="error2">  </p> </div>
                <br> 
                <div> 
                    <input type="submit" value="Modificar"> 
                </div>
            </form>
        </div>
        <br> <br> 
        <div> 
            <form method="post" action="Modificarcom" name="ncom" onsubmit="return modcom()">
            Modificar complexion del usuario: <br><br>
            <div> 
                Elija su nueva complexion: 
                <select name="newcom">
                <option>Ectomorfo</option>
                <option>Endomorfo</option>
                <option>Mesomorfo</option>
                </select>
            </div>
            <br>
            
                <div>
                    Verifica tu contraseña:
                    <input type="password" name="apassword"> 
                </div>
            <div><p id="error3">  </p> </div>
                <br> 
                <div> 
                    <input type="submit" value="Modificar"> 
                </div>
            </form>
        </div>
        
        <script type="text/javascript" src="js/forms/mod.js"></script>
        
        <a href="index.jsp">Regresar al Index</a>
    </body>
</html>
