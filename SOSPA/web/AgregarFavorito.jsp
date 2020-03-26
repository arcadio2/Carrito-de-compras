<%-- 
    Document   : AgregarFavorito
    Created on : 4/05/2019, 07:04:48 PM
    Author     : Vita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            window.onload=function(){
              
		document.forms["miformulario"].submit();
            </script>
    </head>
    <body>
        <%
        int id=Integer.parseInt(request.getParameter("id"));
        
        %>
        <h1>Hello World!</h1>
        
        <form name="miformulario" action="SAgregarFavorito" method="POST">
            <input type="text" name="idfav" value="<%=id%>">
    </form>
    </body>
</html>
