<%@page import="Administrador.Metodos"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio - Administrador -</title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
        <!-- Material Kit CSS -->
        <link href="TEMPLATE/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="TEMPLATE/assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
        <link rel="stylesheet" href="TEMPLATE/assets/css/paper-dashboard.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
    </head>
    <%
        response.setHeader("Pragma", "no-cahce");
        response.addHeader("Cache-control", "must-revalidate");
        response.addHeader("Cache-control", "no-cache");
        response.addHeader("Cache-control", "no-store");
        response.setDateHeader("Expires", 0);
        if (session.getAttribute("username") == null) {
            response.sendError(404);
        } else {
            int id_tus = (Integer) session.getAttribute("id_tus");
            if (id_tus == 1) {

    %> 
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
                            <a class="navbar-brand">Bienvenido Administrador</a>
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
                            <p>Ventas del mes: </p>
                            <%
                                Metodos wish = new Metodos();
                                Statement set = null;
                                ResultSet rs = null;
                                set = wish.conecta().createStatement();
                                rs = set.executeQuery("select * from ventasgrafico");
                            %>
                            <div id="grafico1" style="height: 450px;"></div>
                            <script>
                                new Morris.Line({
                                    // ID of the element in which to draw the chart.
                                    element: 'grafico1',
                                    // Chart data records -- each entry in this array corresponds to a point on
                                    // the chart.
                                    data: [
                                <%                while (rs.next()) {
                                %>
                                        {dia: '<%=rs.getString(2)%>', value: <%=rs.getInt(3)%>},
                                <%    }
                                %>
                                    ],
                                    // The name of the data record attribute that contains x-values.
                                    xkey: 'dia',
                                    // A list of names of data record attributes that contain y-values.
                                    ykeys: ['value'],
                                    // Labels for the ykeys -- will be displayed when you hover over the
                                    // chart.
                                    labels: ['Value'],
                                    resize: true,
                                    lineColors: ['#C14D9F']

                                });
                            </script>
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
