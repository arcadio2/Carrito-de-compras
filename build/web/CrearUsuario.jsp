<%-- 
    Document   : CrearUsuario
    Created on : 26/05/2019, 07:59:41 PM
    Author     : arcad
--%>

<%@page import="Administrador.Metodos"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear usuario</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"> 
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- Material Kit CSS -->
        <link href="TEMPLATE/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="TEMPLATE/assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
        <link rel="stylesheet" href="TEMPLATE/assets/css/paper-dashboard.css">
    </head>
    <body>

        <%
            response.setHeader("Pragma", "no-cahce");
            response.addHeader("Cache-control", "must-revalidate");
            response.addHeader("Cache-control", "no-cache");
            response.addHeader("Cache-control", "no-store");
            response.setDateHeader("Expires", 0);
            if (session.getAttribute("username") == null) {
                response.sendError(404);
            } else if (session.getAttribute("username") != null) {
                int id_tus = (Integer) session.getAttribute("id_tus");
                if (id_tus != 1) {
                    response.sendError(404);
                } else if (id_tus == 1) {


        %>
        <div class="wrapper">
            <div class="sidebar" data-color="black">
                <!--
                Tip 1: You can change the color of the sidebar using: data-color="white | black"
          
                -->
                <div class="logo">
                    <a class="simple-text logo-normal">
                        Globito
                    </a>
                </div>

                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active">
                            <a href="admin.jsp">
                                <i class="nc-icon nc-shop"></i>
                                <p>Inicio</p>
                            </a>
                        </li>

                        <li>
                            <a data-toggle="collapse" href="#pagesExamples">
                                <i class="nc-icon nc-tile-56"></i>
                                <p>Gestionar Productos</p>
                            </a>

                            <div class="collapse" id="pagesExamples">
                                <ul class="nav">
                                    <li>
                                        <a href="ConsultaProductos.jsp">
                                            <span class="sidebar-normal">Consultar</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="AgregaSubproductos.jsp">
                                            <span class="sidebar-normal">Agregar</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="active">
                            <a href="ConsultaUsuarios.jsp">
                                <i class="nc-icon nc-single-02"></i>
                                <p>Consultar Usuarios</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="CrearUsuario.jsp">
                                <i class="nc-icon nc-single-02"></i>
                                <p>Crear usuarios</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="CerrarSesion">
                                <i class="nc-icon nc-button-power"></i>
                                <p>Cerrar sesión</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute">
                    <div class="container-fluid">


                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand">Añadir subproducto</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>


                    </div>
                </nav>
                <style>
                    img{
                        height: 200px;
                    }
                    .card-body{
                        text-align: center;
                    }
                </style>
                <div class="content">
                    <div class="card">
                        <div class="card-body">
                            <div class="agregaproducto">
                                <style>
                                    .tit{
                                        font-size: 35px;
                                        margin-bottom: 25px;
                                    }
                                    input{
                                        width: 450px;
                                        height: 45px;
                                        margin-bottom: 25px;
                                    }
                                    select{
                                        width: 450px;
                                        height: 35px;
                                        margin-bottom: 25px;
                                    }
                                    .agregar{
                                        width: 250px;
                                        height: 35px;
                                        margin-bottom: 75px;
                                    }
                                </style>
                                <h1>Agrega un trabajador</h1>
                                <form action="CrearEmpleado" name="form" id="form"> 
                                    <label>Selecciona el tipo de trabajador</label>
                                    <select name="select">  <p id="a1"></p>
                                        <option>--Selecciona una opcion--</option>
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
                            </div>
                        </div>
                    </div>          
                </div>
            </div>
        </div>
        <script src="JS/ValidarAdmin.js"></script>
        <script src="TEMPLATE/assets/js/core/jquery.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/core/popper.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/plugins/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <script src="JS/jquery.js" charset="utf-8" type="text/javascript"></script> 
        <script src="JS/Jquery-validate.js" charset="utf-8" type="text/javascript"></script> 
        <script src="JS/add.js" charset="utf-8" type="text/javascript"></script> 


        <%}
        
      }%>
    </body>
</html>
