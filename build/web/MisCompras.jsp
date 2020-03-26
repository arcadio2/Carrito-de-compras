<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Controlador.*" %>

<%@ page session="true" %>
<%
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
usuario = (String)sesionOk.getAttribute("usuario");
}
%>

<%-- Validar inicio de sesion --%>


<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
        int idus= (Integer) sesionOk.getAttribute("id");
        Vector<Venta> vecVen=new Venta().listaVentas(idus);
       Vector<Detalleventa> vectorDetalles=(Vector<Detalleventa>)session.getAttribute("detalleVenta");
        int carrito=0;
        if(vectorDetalles==null){
            carrito=0;
        }else{
        carrito=vectorDetalles.size();
        }
        
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
							
                                                    <div><%=usuario%></div>
                                                     
						</div>
					</div>
				</a>
				<a href="CerrarSesion">Cerrar Sesión</a><!--  dropdown-menu .// -->
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
  <th scope="col">Codigo Venta</th>
  <th scope="col" width="350">Fecha</th>
  
  <th scope="col" width="120">Total a Pagar</th>
  <th scope="col" class="text-right" width="200">Estado</th>
  <th scope="col" class="text-right">Acción</th>
</tr>
</thead>
<tbody>
    

          <%
            for(Venta ven:vecVen){
                String estado="";
                String boton="";
                String accion="";
                if(ven.getIdpago()==2){
                    estado="En espera de pago...";
                    boton="warning";
                    accion="× Cancelar";
                }else{
                    estado="Pagado";
                    boton="success";
                    accion="× Eliminar";
                }
               String direccion="";
               direccion="DetalleVenta.jsp?id="+ven.getVenta_codigo();
          %>    
          
     
<tr>
	<td>
<figure class="media">
    
	<figcaption class="media-body">
            <h6 class="title text-truncate"><%=ven.getVenta_codigo()%></h6>
            <a href="<%=direccion%>" class="btn btn-outline-primary">Detalle</a>
		
	</figcaption>
</figure> 
	</td>
	<td> 
		
            <h4><%=ven.getVenta_fecha() %></h4>
				
		</select 
	</td>
	<td> 
		<div class="price-wrap"> 
			<var class="price">MXN <%=ven.getVenta_totalpagar() %></var> 
                         
		</div> <!-- price-wrap .// -->
	</td>
	<td class="text-right"> 
            
            <button type="button" onlyread class="btn btn-outline-<%=boton%>"> <%=estado%></button>
           
	</td>
        <td class="text-right"> 
            <form action="SEliminarVenta">
                <input type="text" hidden id="idven" name="idven" value="<%=ven.getVenta_codigo()%>">
            <button type="submit" onlyread class="btn btn-outline-danger"><%=accion%> </button>
           </form>
	</td>
</tr>
<%}%>

  
</tbody>
</table>
</div> <!-- card.// -->

	</main> <!-- col.// -->
	
 <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>

       
</body>
</html>