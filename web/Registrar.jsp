
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>El Globito</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
        <script src="JS/jquery.js" charset="utf-8" type="text/javascript"></script> 
        <script src="JS/Jquery-validate.js" charset="utf-8" type="text/javascript"></script> 
        <script src="JS/main.js" charset="utf-8" type="text/javascript"></script> 

        <section class="section-content bg padding-y">
            <div class="container">

                <div class="row"> <!-- col.// -->
                    <main class="col-sm-9">
                        <article class="card card-product">
                            <div class="card-body">
                                <div class="row">
                                    <article class="col-sm-6">
                                        <div class="container">
                                            <h1 class="registro">Ingresa tus datos</h1>
                                            <form method="POST" action="CrearUsuario" id="form" name="form"> 

                                                <div class="problema-container">

                                                    <label>Nombre de usuario:</label><br>
                                                    <input class="problema-input" type="text" maxlength="25" autocomplete="off" id="username" name="username"> <br><br>
                                                    <label>Correo:</label><br>
                                                    <input class="problema-input" type="email" maxlength="75" autocomplete="off" id="email" name="email"> <br> <br>
                                                    <label>Contraseña:</label><br>
                                                    <input class="problema-input" type="password"  autocomplete="off" id="password" name="password"> <br><br>
                                                    <label>Verificar Contraseña:</label><br>
                                                    <input class="problema-input" type="password" autocomplete="off" id="rpassword" name="rpassword"> <br><br>


                                                    <br><br>
                                                    <p id="avisos"> </p> 

                                                    <input class="problema-input2" type="submit" id="btn-registro" name="btn-registro" value="Registrarse" > <br><br>
                                                    <a href="index.jsp">Regresar</a>
                                                </div>
                                            </form>

                                        </div>
                                        <!-- item-property-hor .// -->

                                    </article><!-- col.// -->
                                </div> <!-- row.// -->
                            </div> <!-- card-body .// -->
                        </article> <!-- card product .// -->
                        <!-- card product .// -->

                    </main> <!-- col.// -->
                </div>

            </div> <!-- container .//  -->
        </section>

    </body>
</html>