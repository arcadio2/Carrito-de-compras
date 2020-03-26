<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Controlador.*" %>

<%@ page session="true" %>
<%
    String usuario = "";
    HttpSession sesionOk = request.getSession();
    response.setHeader("Pragma", "no-cahce");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    if (session.getAttribute("username") == null) {
        response.sendRedirect("IniciarSesion.jsp");
    } else {
        int id_tus = (Integer) session.getAttribute("id_tus");
        if (id_tus != 2) {
            response.sendError(404);
        } else {


%>
<%-- Validar inicio de sesion --%>


<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

<%        if (request.getParameter("cod") == null) {
        response.sendRedirect("AgregarProducto1.jsp");
    } else {

        Producto pro = new Producto().buscarProducto(Integer.parseInt(request.getParameter("cod")));
        if (pro == null) {
            response.sendRedirect("AgregarProducto1.jsp");
        } else {
            Vector<Detalleventa> vectorDetalles = (Vector<Detalleventa>) session.getAttribute("detalleVenta");
            int carrito = 0;
            if (vectorDetalles == null) {
                carrito = 0;
            } else {
                carrito = vectorDetalles.size();
            }

%>

<%-- Finalizar --%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="pragma" content="no-cache" />
        <meta http-equiv="cache-control" content="max-age=604800" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="author" content="Bootstrap-ecommerce by Vosidiy">

        <title>Productos</title>

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
        <script type="text/javascript">
        /// some script

        // jquery ready start
            $(document).ready(function () {
                // jQuery code

            });
        // jquery end
        </script>

    </head>
    <body>
        <header class="section-header">

            <section class="header-main shadow-sm">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-sm-4">
                            <div class="brand-wrap">

                                <h2 class="logo-text">Panadería</h2>
                            </div> <!-- brand-wrap.// -->
                        </div>
                        <div class="col-lg-4 col-xl-5 col-sm-8">
                            <!-- search-wrap .end// -->
                        </div> <!-- col.// -->
                        <div class="col-lg-5 col-xl-4 col-sm-12">
                            <div class="widgets-wrap float-right">
                                <a href="AgregarProducto1.jsp?pan=1" class="widget-header mr-3">
                                    <div class="icontext">
                                        <div class="icon-wrap"><i class="icon-sm round border fa fa-cart-plus"></i></div>
                                        <div class="text-wrap">

                                            <div>Productos</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="MostrarCarrito.jsp" class="widget-header mr-3">
                                    <div class="icontext">
                                        <div class="icon-wrap"><i class="icon-sm round border fa fa-shopping-cart"></i></div>
                                        <div class="text-wrap">
                                            <span class="small badge badge-danger"><%=carrito%></span>
                                            <div>Carrito</div>
                                        </div>
                                    </div>
                                </a>

                                <div class="widget-header dropdown">
                                    <a href="MisCompras.jsp" data-offset="20,10">
                                        <div class="icontext">
                                            <div class="icon-wrap"><i class="icon-sm round border fa fa-user"></i></div>
                                            <div class="text-wrap">

                                                <div><%=usuario%> </div>
                                            </div>
                                        </div>
                                    </a>
                                    <!--  dropdown-menu .// -->
                                </div>  <!-- widget-header .// -->
                            </div> <!-- widgets-wrap.// -->
                        </div> <!-- col.// -->
                    </div> <!-- row.// -->
                </div> <!-- container.// -->
            </section> <!-- header-main .// -->
        </header><form name="frmPrincipal" action="SAgregarCarro"  method="post">
            <main class="card">
                <div class="row no-gutters">
                    <aside class="col-sm-6 border-right">
                        <article class="gallery-wrap"> 
                            <div class="img-big-wrap">
                                <div> <a href="<%=pro.getUrl_pro()%>" data-fancybox=""><img src="<%=pro.getUrl_pro()%>"></a></div>
                            </div> <!-- slider-product.// -->

                        </article> <!-- gallery-wrap .end// -->
                    </aside>
                    <aside class="col-sm-6">
                        <article class="card-body">
                            <!-- short-info-wrap -->
                            <h3 class="title mb-3"><%=pro.getProducto_nombre()%></h3>

                            <div class="mb-3"> 
                                <var class="price h3 text-warning"> 
                                    <span class="currency">MXN $</span><span class="num"><%=pro.getProducto_precio()%></span>
                                </var> 
                                <span> c/u</span> 
                            </div> <!-- price-detail-wrap .// -->

                            <hr>
                            <div class="row">
                                <div class="col-sm-5">
                                    <dl class="dlist-inline">
                                        <dt>Cantidad: </dt>
                                        <dd> 
                                            <select name="txtCantidadPedir" class="form-control form-control-sm" id="txtCantidadPedir" style="width:70px;">
                                                <%
                                                    int contar = pro.getProducto_stock();
                                                    for (int i = 1; i <= contar; i++) {


                                                %>	
                                                <option> <%=i%> </option>

                                                <%}%>
                                            </select>
                                        </dd>
                                    </dl>  <!-- item-property .// -->
                                </div> <!-- col.// -->
                                <!-- col.// -->
                            </div> <!-- row.// -->
                            <hr>
                            <input type="submit" class="btn  btn-outline-warning" name="button" id="button" value="Agregar al carrito">
                            <!-- short-info-wrap .// -->
                        </article> <!-- card-body.// -->
                    </aside> <!-- col.// -->
                </div> <!-- row.// -->
            </main>




            <input name="txtCodigo" hidden type="text" id="txtCodigo" size="10" readonly value="<%=pro.getProducto_codigo()%>" >
            <input name="txtProducto" hidden type="text" id="txtProducto" size="60" readonly value="<%=pro.getProducto_nombre()%>" ></td>
            <input name="txtPrecio" hidden type="text" id="txtPrecio" size="15" readonly value="<%=pro.getProducto_precio()%>"></td>
            <input name="txtStock" hidden type="text" id="txtStock" size="15" readonly value="<%=pro.getProducto_stock()%>"></td>




        </form>
    </body>
    <%}
    }%>
</html>
<%}
    }%>