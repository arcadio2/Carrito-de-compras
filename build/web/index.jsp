
<%@page contentType="text/html; charset=iso-8859-1" session="true" 
        language="java" import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Panaderia cokitos</title>
        <style type="text/css">

        </style>
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
        <header class="section-header">

            <section class="header-main shadow-sm">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-sm-4">
                            <div class="brand-wrap">

                                <h2 class="logo-text">Panadería "cokitos"</h2>
                            </div> <!-- brand-wrap.// -->
                        </div>
                        <div class="col-lg-4 col-xl-5 col-sm-8">
                            <!-- search-wrap .end// -->
                        </div> <!-- col.// -->
                        <div class="col-lg-5 col-xl-4 col-sm-12">
                            <div class="widgets-wrap float-right">
                                <a href="Registrar.jsp" class="widget-header mr-3">
                                    <div class="icontext">
                                        <div class="icon-wrap"><i class="icon-sm round border fas fa-clipboard"></i></div>
                                        <div class="text-wrap">
                                            <div>Registrarte</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="IniciarSesion.jsp" class="widget-header mr-3">
                                    <div class="icontext">
                                        <div class="icon-wrap"><i class="icon-sm round border far fa-clipboard"></i></div>
                                        <div class="text-wrap">
                                            <div>Iniciar Sesión</div>
                                        </div>
                                    </div>
                                </a>
                                <!-- widget-header .// -->
                            </div> <!-- widgets-wrap.// -->
                        </div> <!-- col.// -->
                    </div> <!-- row.// -->
                </div> <!-- container.// -->
            </section> <!-- header-main .// -->
        </header><!-- section-header.// -->





        <section class="section-content bg padding-y">
            <div class="container">

                <div class="row">
                    <aside class="col-sm-3">

                        <div class="card card-filter">
                            <article class="card-group-item">
                                <header class="card-header">
                                    <a class="" aria-expanded="true" href="#" data-toggle="collapse" data-target="#collapse22">
                                        <i class="icon-action fa fa-chevron-down"></i>
                                        <h6 class="title">Nuestros productos son:</h6>
                                    </a>
                                </header>
                                <div style="" class="filter-content collapse show" id="collapse22">
                                    <div class="card-body">
                                        <ul class="list-unstyled list-lg">
                                            <li><span class="float-right badge badge-light round">Pasteles</span></li>
                                            <li><span class="float-right badge badge-light round">Pan dulce</span></li>
                                            <li><span class="float-right badge badge-light round">Helados</span></li>
                                            <li><span class="float-right badge badge-light round">Gelatinas</span></li>
                                            <li><span class="float-right badge badge-light round">Pan salado</span></li>
                                            <li><span class="float-right badge badge-light round">Donas</span></li>
                                        </ul>  
                                    </div> <!-- card-body.// -->
                                </div> <!-- collapse .// -->
                            </article> <!-- card-group-item.// -->
                            <!-- card-group-item.// -->
                            <!-- card-group-item.// -->
                        </div> <!-- card.// -->


                    </aside> <!-- col.// -->
                    <main class="col-sm-9">
                        <article class="card card-product">
                            <div class="card-body">
                                <div class="row">
                                    <aside class="col-sm-3">
                                        <div class="img-wrap"><img src="https://images7.alphacoders.com/330/thumb-1920-330077.jpg"></div>
                                    </aside> <!-- col.// -->
                                    <article class="col-sm-6">
                                        <h4 class="title">Bienvenido a nuestra panaderia</h4>

                                        <!-- item-property-hor .// -->

                                    </article> <!-- col.// -->
                                    <aside class="col-sm-3 border-left">
                                        <div class="action-wrap">
                                            <div class="price-wrap h4">
                                            </div> <!-- info-price-detail // -->
                                            <br>
                                                <p>
                                                    <i>"Los mejores panes del mundo"</i>
                                                </p>

                                        </div> <!-- action-wrap.// -->
                                    </aside> <!-- col.// -->
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