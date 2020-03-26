

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar  - Sesión</title>
        <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">

        <!-- jQuery -->

        <script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/jquery-2.0.0.min.js" type="text/javascript"></script>
        <!-- Bootstrap4 files-->

        <script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- Font awesome 5 -->
        <link href="bootstrap-ecommerce-uikit/ui-ecommerce/fonts/fontawesome/css/fontawesome-all.css" rel="stylesheet" type="text/css"/>
        <!-- custom style -->
        <link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/ui.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/responsive.css" rel="stylesheet" type="text/css"/>
        <!-- custom javascript -->
        <script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            response.setHeader("Pragma", "no-cahce");
            response.addHeader("Cache-control", "must-revalidate");
            response.addHeader("Cache-control", "no-cache");
            response.addHeader("Cache-control", "no-store");
            response.setDateHeader("Expires", 0);
            if (session.getAttribute("username") == null) {

        %>     
        <script src="JS/jquery.js" charset="utf-8" type="text/javascript"></script> 
        <script src="JS/Jquery-validate.js" charset="utf-8" type="text/javascript"></script> 
        <script src="JS/main.js" charset="utf-8" type="text/javascript"></script> 

        <div class="d-flex justify-content-center">

            <div class="col-sm-4">
                <article class="card-body">
                    <h4 class="card-title text-center mb-4 mt-1">Iniciar sesión</h4>
                    <hr>

                    <form class="text-center border border-light p-5" action="Encuesta.jsp" method="post" name="inicio" id="inicio" >
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                                </div>
                                <input type="text" id="defaultLoginFormEmail"  name="defaultLoginFormEmail" class="form-control" placeholder="Usuario" >
                            </div> <!-- input-group.// -->
                        </div> <!-- form-group// -->
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                                </div>
                                <input type="password" id="defaultLoginFormPassword" name="defaultLoginFormPassword" class="form-control" placeholder="******" >
                            </div> <!-- input-group.// -->
                        </div> <!-- form-group// -->
                        <div class="form-group">

                            <button class="btn btn-primary btn-block" type="submit" id="bot-is">Iniciar sesión</button>
                            <p id="myavisos"> </p> 
                        </div> <!-- form-group// -->
                        <p class="text-center"><a href="index.jsp" class="btn">Inicio</a></p>
                        <p>¿Aún no te has registrado?
                            <a href="Registrar.jsp">Registrarse</a>
                        </p>

                    </form>
                </article>
            </div> 
        </div>
        <%} else if (session.getAttribute("username") != null) {
                response.sendRedirect("Home.jsp");
            }%>
    </body>
</html>


