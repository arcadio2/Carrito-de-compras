<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Controlador.*" %>

<%@ page session="true" %>
<%
String usuario = "";
HttpSession sesionOk = request.getSession();

%>

<%-- Validar inicio de sesion --%>


<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
        
        if(session.getAttribute("detalleVenta")==null){
            response.sendRedirect("AgregarProducto1.jsp?pan=1");
        }else{
        Vector<Detalleventa> vectorDetalles=(Vector<Detalleventa>)session.getAttribute("detalleVenta");
       
        
        
    %>

<%-- Finalizar --%>
<!DOCTYPE HTML>
<html lang="en">
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
                                            <span class="small badge badge-danger"><%=vectorDetalles.size()%></span>
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
</header> <!-- section-header.// -->
    <section class="section-content bg padding-y border-top">
<div class="container">

<div class="row">
	<main class="col-mb">

<div class="card">
<table class="table table-hover shopping-cart-wrap">
<thead class="text-muted">
<tr>
  <th scope="col">Producto</th>
  <th scope="col" width="120">Cantidad</th>
  <th scope="col" width="120">Precio</th>
  <th scope="col" class="text-right" width="200">Acción</th>
</tr>
</thead>
<tbody>
    

          <%
            for(Detalleventa det:vectorDetalles){
                Producto pro=new Producto().buscarProducto(det.getProducto_codigo());
                SProducto spro=new SProducto().buscarSProducto(pro.getId_pro());
                
               
          %>    
          
     
<tr>
	<td>
<figure class="media">
    <div class="img-wrap"><img src="<%=pro.getUrl_pro()%>" class="img-thumbnail img-sm"></div>
	<figcaption class="media-body">
            <h6 class="title text-truncate"><%=pro.getProducto_nombre()%></h6>
		<dl class="dlist-inline small">
		  <dt>Tipo: </dt>
		  <dd><%=spro.getProducto_nombre()%></dd>
		</dl>
		
	</figcaption>
</figure> 
	</td>
	<td> 
		<select class="form-control" onmouseover="this.disabled=true;" onmouseout="this.disabled=false;">
			<option><%=det.getDetventa_cantidad() %></option>
				
		</select> 
	</td>
	<td> 
		<div class="price-wrap"> 
			<var class="price">MXN <%=det.getDetventa_subtotal() %></var> 
                        <small class="text-muted">(MXN <%=pro.getProducto_precio()%> c/u)</small> 
		</div> <!-- price-wrap .// -->
	</td>
	<td class="text-right"> 
            <form action="SEliminarCarrita">
                <input type="text" hidden value="<%=vectorDetalles.indexOf(det)%>" name="iddet" id="iddet">
            <button type="submit" class="btn btn-outline-danger">  Eliminar</button>
            </form>
	</td>
</tr>
<%}%>
<tr>
    <td colspan="3" ></td>
      <td class="text-right">
            <a href="SFinalizarCompra" class="btn btn-outline-success">Finalizar Compra</a>
      </td>
  </tr>
  
</tbody>
</table>
</div> <!-- card.// -->

	</main> <!-- col.// -->
	
 <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>

       
</body>
</html><%}%>