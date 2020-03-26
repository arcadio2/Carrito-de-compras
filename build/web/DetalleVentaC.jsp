<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Controlador.*" %>

<%@ page session="true" %>
<%
    response.setHeader("Pragma", "no-cahce");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    String usuario = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="IniciarSesion.jsp">
    <jsp:param name="error" value="Es
               obligatorio identificarse"/>
</jsp:forward>
<%
    } else {
        usuario = (String) sesionOk.getAttribute("usuario");
        int id_tus= (Integer) session.getAttribute("id_tus"); 
        if (id_tus!=4) {
                response.sendError(404);
            }else{
%>
<%-- Validar inicio de sesion --%>


<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
        if(request.getParameter("id")==null){
        response.sendRedirect("MisCompras.jsp");
        }else{
            
    int id=Integer.parseInt(request.getParameter("id"));
     Vector<Detalleventa> vecVen=new Detalleventa().listaDetalleVenta(id);
       Vector<Detalleventa> vectorDetalles=(Vector<Detalleventa>)session.getAttribute("detalleVenta");
        int carrito=0;
        if(vectorDetalles==null){
            carrito=0;
        }else{
        carrito=vectorDetalles.size();
        }
        
    
    %>

<%-- Finalizar --%>

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
</header>  <!-- section-header.// -->
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
 
</tr>
</thead>
<tbody>
    <%
            for(Detalleventa dev:vecVen){
                Producto pro=new Producto().buscarProducto(dev.getProducto_codigo());
                
          %>
          <tr>
	<td>
<figure class="media">
    
	<figcaption class="media-body">
            <h6 class="title text-truncate"><%=pro.getProducto_nombre()%></h6>
            
	</figcaption>
</figure> 
	</td>
	<td> 
		
            <h4><%=dev.getDetventa_cantidad()%></h4>
				
		</select 
	</td>
	<td> 
		<div class="price-wrap"> 
			<var class="price">MXN <%=dev.getDetventa_subtotal()%></var> 
                         
		</div> <!-- price-wrap .// -->
	</td>
	
</tr>
          <%}%>
<tr>
    <td colspan="2" ></td>
      <td class="text-right">
            <a href="Cajero.jsp" class="btn btn-outline-primary"> Regresar</a></td>
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
<%}
}%>
</html>
<%}%>