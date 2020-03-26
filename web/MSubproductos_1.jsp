
<%@page import="Administrador.Metodos"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Subproducto - Administrador - </title>
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
                            <a href="admin.jsp">
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
                            <a class="navbar-brand">Modificar subproducto</a>
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
                                <form method="post" action="ModificarSubproducto" id="subproducto" onkeypress="EnterSubproductoM(event)">
                                    <%
                                        Statement set = null;
                                        ResultSet rs = null;
                                        Metodos deseo = new Metodos();
                                        int id = Integer.parseInt(request.getParameter("id"));

                                        try {
                                            set = deseo.conecta().createStatement();
                                            rs = set.executeQuery("select * from subproducto where id_sub = " + id + ";");
                                            rs.last();

                                        } catch (Exception e) {
                                            e.getMessage();
                                            e.getStackTrace();
                                        }
                                    %>
                                    <p class="tit">Nombre: </p>
                                    <input type="text" minlength="3" maxlength="15" autocomplete="off" name="subproducto" id="subproducto-2" value="<%=rs.getString(2)%>">
                                    <p class="tit">Imagen: </p>
                                    <input type="text" minlength="1" maxlength="2084" autocomplete="off" name="url" id="subproducto-3" value="<%=rs.getString(3)%>">
                                    <input type="hidden" value="<%=id%>" name="id">
                                </form>
                                <button class="agregar" onclick="ValidaSubproductoModifica()">Aceptar</button>
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
    </body>
</html>
