
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Administrador.Metodos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Productos - Administrador - </title>
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
            }else{
                int id_tus =(Integer) session.getAttribute("id_tus");
                if (id_tus==1) {

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
                            <a class="navbar-brand">Consultar Usuarios</a>
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
                    .contenido{
                        width: 100%;
                    }
                    .pro{
                        width: 100%;
                        display: grid;
                        grid-template-columns: 1fr 1fr 1fr 1fr;
                        border-bottom: 1px solid black;
                    }
                    .imagen{
                        grid-column: 1/1;
                        text-align: center;
                    }
                    .imagen > img{
                        height: 120px;
                    }
                    .nombre{
                        grid-column: 2/2;
                        text-align: center;
                        padding-top: 50px; 
                    }
                    .modify-2{
                        grid-column: 3/3;
                        text-align: center;
                        display: grid;
                        grid-template-columns: 1fr;
                    }
                    .delete-2{
                        grid-column: 4/4;
                        text-align: center;
                        display: grid;
                        grid-template-columns: 1fr;
                    }
                    .cual{
                        width: 100%;
                        text-align: left;
                    }
                    .prod{
                        font-size: 25px;
                        height: 65px;
                        color: #A13650;
                    }
                    .delete-2 > a {
                        color: black;
                        grid-column: 1/1;
                        height: 130px;
                        padding-top: 50px; 
                    }
                    .modi{
                        color: black;
                        grid-column: 1/1;
                        height: 130px;
                        padding-top: 50px; 
                    }
                    .modi:hover{
                        text-decoration: none;
                        background-color: black;
                        color: white;
                    }
                    .collapse{
                        display: grid;
                        grid-template-columns: 1fr;
                    }
                    .acept{
                        color: black;
                        grid-column: 1/1;
                        transition: 0.5s;
                        height: 25px;
                        padding-top: 5px;
                    }
                    .acept:hover{
                        text-decoration: none;
                        background-color: black;
                        color: white;
                    }
                </style>
                <div class="content">
                    <div class="card">
                        <div class="card-body">
                            <div class="contenido">
                                <%
                                    Metodos deseo = new Metodos();
                                    Statement set = null;
                                    ResultSet rs = null;
                                    set = deseo.conecta().createStatement();
                                %>
                                <div class="cual">
                                    <p class="prod">Usuarios</p>
                                </div>
                                <%
                                    rs = set.executeQuery("select * from usuario where id_tus = 2");
                                    while (rs.next()) {
                                %>
                                <div class="pro">
                                    <div class="imagen">
                                        <%=rs.getString(2)%>
                                    </div>
                                    <div class="nombre">
                                        <%=rs.getString(3)%>
                                    </div>
                                    <div class="modify-2">
                                        <a href="MUsuario.jsp?id=<%=rs.getInt(1)%>" class="modi">
                                            Modificar
                                        </a>
                                    </div>
                                    <div class="delete-2">
                                        <a data-toggle="collapse" href="#confirmar<%=rs.getInt(1)%>" class="acept">
                                            Eliminar
                                        </a>
                                        <div class="collapse" id="confirmar<%=rs.getInt(1)%>">
                                            <p>¿Esta segúro de eliminar este elemento?, el cambio sera permanente</p>
                                            <a href="EliminarUsuario?id=<%=rs.getInt(1)%>" class="acept">
                                                Aceptar
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>          
                </div>
            </div>
        </div>

        <script src="TEMPLATE/assets/js/core/jquery.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/core/popper.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/plugins/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
        <script src="TEMPLATE/assets/js/plugins/moment.min.js"></script>
        
              <%}else{
            response.sendError(404);
        }
        }
        %>
        
    </body>
</html>
