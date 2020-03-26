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
            }else{
                int id_tus=(Integer) session.getAttribute("id_tus"); 
                if (id_tus!=2) {
                        response.sendError(404);
                    }else{
                    
                
            
%>



<%-- Obtener Vector de Productos de la BD --%>

    <%if(request.getParameter("pan")==null){
        Vector<Producto> vecPro=new Producto().listaTProductos();
        Vector<Detalleventa> vectorDetalles=(Vector<Detalleventa>)session.getAttribute("detalleVenta");
        int carrito=0;
        if(vectorDetalles==null){
            carrito=0;
        }else{
        carrito=vectorDetalles.size();
        }
        Vector<SProducto> vecSPro=new SProducto().listaSProductos();
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
$(document).ready(function() {
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
				<h6 class="title">Pan</h6>
			</a>
		</header>
		<div style="" class="filter-content collapse show" id="collapse22">
			<div class="card-body">
				
          
          
                            
				<ul class="list-unstyled list-lg">
                                    <%
              
            for(SProducto pro:vecSPro){
                String direccion="AgregarProducto1.jsp"+"?pan="+pro.getProducto_codigo();
          %>
          <li><a href="<%=direccion%>"><%=pro.getProducto_nombre()%><span class="float-right badge badge-light round"><%=pro.contarProducto(pro.getProducto_codigo())%></span> </a></li>
					<%}%>
                                </ul>  
			</div> <!-- card-body.// -->
		</div> <!-- collapse .// -->
	</article> <!-- card-group-item.// -->
	<!-- card-group-item.// -->
	 <!-- card-group-item.// -->
</div> <!-- card.// -->


	</aside> <!-- col.// -->
	<main class="col-sm-9">

<%
                  
                  for(Producto pro:vecPro){
              String direccion="AgregarProducto2.jsp?cod=" +pro.getProducto_codigo() ;
              
                  %>
              
              
<article class="card card-product">
	<div class="card-body">
	<div class="row">
		<aside class="col-sm-3">
                    <div class="img-wrap"><img src="<%=pro.getUrl_pro()%>"></div>
		</aside> <!-- col.// -->
		<article class="col-sm-6">
				<h4 class="title"><%=pro.getProducto_nombre() %> </h4>
				
				 <!-- item-property-hor .// -->
			
		</article> <!-- col.// -->
		<aside class="col-sm-3 border-left">
			<div class="action-wrap">
				<div class="price-wrap h4">
					<span class="price">$ <%=pro.getProducto_precio() %></span>	
					
				</div> <!-- info-price-detail // -->
				
				<br>
				<p>
                                    <%if(pro.getProducto_stock()>0){
                                    
                                    %>
					<a href="<%= direccion%>" class="btn btn-primary"> Comprar </a>
					<%}else{%>
                                        <a href="#" class="btn btn-outline-warning" > No hay producto disponible </a>
                                        <%}%>
				</p>
				
			</div> <!-- action-wrap.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
	</div> <!-- card-body .// -->
</article> <!-- card product .// -->
<%}%>
 <!-- card product .// -->

	</main> <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>
</body>

</html>

<%
        }else{
        int idPro= Integer.parseInt(request.getParameter("pan"));
        Vector<Producto> vecPro=new Producto().listaProductos(idPro);
        Vector<Detalleventa> vectorDetalles=(Vector<Detalleventa>)session.getAttribute("detalleVenta");
        int carrito=0;
        if(vectorDetalles==null){
            carrito=0;
        }else{
        carrito=vectorDetalles.size();
        }
    %>
<%
                       
        Vector<SProducto> vecSPro=new SProducto().listaSProductos();
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
$(document).ready(function() {
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
				<h6 class="title">Pan</h6>
			</a>
		</header>
		<div style="" class="filter-content collapse show" id="collapse22">
			<div class="card-body">
				
          
          
                            
				<ul class="list-unstyled list-lg">
                                    <%
              
            for(SProducto pro:vecSPro){
                String direccion="AgregarProducto1.jsp"+"?pan="+pro.getProducto_codigo();
          %>
          <li><a href="<%=direccion%>"><%=pro.getProducto_nombre()%><span class="float-right badge badge-light round"><%=pro.contarProducto(pro.getProducto_codigo())%></span> </a></li>
					<%}%>
                                </ul>  
			</div> <!-- card-body.// -->
		</div> <!-- collapse .// -->
	</article> <!-- card-group-item.// -->
	<!-- card-group-item.// -->
	 <!-- card-group-item.// -->
</div> <!-- card.// -->


	</aside> <!-- col.// -->
	<main class="col-sm-9">

<%
                  
                  for(Producto pro:vecPro){
              String direccion="AgregarProducto2.jsp?cod=" +pro.getProducto_codigo() ;
              
                  %>
              
              
<article class="card card-product">
	<div class="card-body">
	<div class="row">
		<aside class="col-sm-3">
                    <div class="img-wrap"><img src="<%=pro.getUrl_pro()%>"></div>
		</aside> <!-- col.// -->
		<article class="col-sm-6">
				<h4 class="title"><%=pro.getProducto_nombre() %> </h4>
				
				 <!-- item-property-hor .// -->
			
		</article> <!-- col.// -->
		<aside class="col-sm-3 border-left">
			<div class="action-wrap">
				<div class="price-wrap h4">
					<span class="price">$ <%=pro.getProducto_precio() %></span>	
					
				</div> <!-- info-price-detail // -->
				
				<br>
				<p>
                                    <%if(pro.getProducto_stock()>0){
                                    
                                    %>
					<a href="<%= direccion%>" class="btn btn-primary"> Comprar </a>
					<%}else{%>
                                        <a href="#" class="btn btn-outline-warning" > No hay producto disponible </a>
                                        <%}%>
				</p>
				
			</div> <!-- action-wrap.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
	</div> <!-- card-body .// -->
</article> <!-- card product .// -->
<%}%>
 <!-- card product .// -->

	</main> <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>
</body>
<%}
}%>
</html>
<%}%>