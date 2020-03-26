<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ page session="true" %>
<%
    String usuario = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="login.jsp">
    <jsp:param name="error" value="Es
               obligatorio identificarse"/>
</jsp:forward>
<%
    } else {
        usuario = (String) sesionOk.getAttribute("usuario");
    }
%>

<html>
    <head>
        <title>.:PAW-Agregar Productos</title>
        <style type="text/css">
            <!--
            body {
                background-color: #FFFF99;
            }
            body,td,th {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>
    <body>
        <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">

            <tr align="center">
                <td colspan="2">&nbsp;</td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <h4> | <a href="AgregarProducto1.jsp">Agregar al Carrito</a> |  </h4></td>
            </tr>
            <tr>
                <td colspan="2"><h1>SE REGISTRO LA COMPRA DE FORMA CORRECTA</h1></td>
            </tr>

            <tr>
                <td colspan="2">&nbsp;</td>
            </tr>
        </table>
    </body>
</html>
