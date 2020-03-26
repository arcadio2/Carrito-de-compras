<%-- 
    Document   : Modificar
    Created on : 26/05/2019, 11:07:38 AM
    Author     : arcad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <script src="JS/jquery.js" charset="utf-8" type="text/javascript"> </script> 
            <script src="JS/Jquery-validate.js" charset="utf-8" type="text/javascript"> </script> 
            <script src="JS/mod.js" charset="utf-8" type="text/javascript"> </script> 
 <%
    response.setHeader("Pragma", "no-cahce");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    if (session.getAttribute("username")== null) {
            response.sendRedirect("index.jsp");
        }else if (session.getAttribute("username")!= null){
             int id_tus= (Integer) session.getAttribute("id_tus");    
        if (id_tus == 1 ) {
                response.sendRedirect("admin.jsp");
            }else{
 %>       
        
               <h1>Modificar Cuenta</h1>
        Hola <%=session.getAttribute("username")%> <br> 
        De contraseña: <%=session.getAttribute("password")%>
        <br><br>
        <div> 
            Modificar nombre de usuario: <br><br>
            <div class="form-group">
        <form action="Modificiar" name="modnom" id="modnom" method="post">
            <div> 
                Escribe el nuevo nombre de usuario:
                <input class="form-control" type="text" name="cnom">  
            </div>
            <br>
            <div> 
                Escribe tu contraseña: 
                <input class="form-control" type="password" name="password"> 
            </div>
            <div><p id="error">  </p> </div>
            <div> 
                <input class="btn btn-primary" type="submit" name="envcnom">  
            </div>
                       
        </form>
            <%//%>
        </div>
         <br> <br> 
        <div> 
            Modificar contraseña: <br><br>
            <form action="Modificiar" method="post" name="mpass" id="mpass">
                <div> 
                    Escribe tu nueva contraseña: 
                    <input class="form-control" type="password" name="cpassword" id="cpassword">
                </div>
                <br>
                <div>
                    Verifica tu contraseña:
                    <input class="form-control" type="password" name="apassword" id="apassword"> 
                </div>
                <div><p id="error2">  </p> </div>
                <br> 
                <div> 
                    <input class="btn btn-primary" type="submit" value="Modificar"> 
                </div>
            </form>
        </div>
        <br> <br> 
       
        
        <a href="index.jsp" class="badge badge-info">Regresar al Index</a>
        </div></div>

 

 <%}
 }%>
    </body>
</html>
