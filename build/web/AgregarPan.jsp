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
        if (id_tus!=3) {
                response.sendError(404);
            }else{
%>
<%-- Validar inicio de sesion --%>


<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
        if(request.getParameter("cod")==null){
        response.sendRedirect("AgregarProducto1.jsp");
        }else{
            
    Producto pro=new Producto().buscarProducto(Integer.parseInt(request.getParameter("cod")));
    if(pro==null){
    response.sendRedirect("AgregarProducto1.jsp");
    }else{
    
    
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
</header>

        <form name="frmPrincipal" action="SAgregarPan"  method="post">

        <table width="100%" border="0" cellpadding="0">
      <tr>
        <td width="17%" bgcolor="#FF0000"><span class="Estilo3">Codigo:</span></td>
        <td width="83%"><label>
          <input name="txtCodigo" type="text" id="txtCodigo" size="10" readonly value="<%=pro.getProducto_codigo() %>" >
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#FF0000"><span class="Estilo3">Producto:</span></td>
        <td><input name="txtProducto" type="text" id="txtProducto" size="60" readonly value="<%=pro.getProducto_nombre() %>" ></td>
      </tr>
      <tr>
        <td bgcolor="#FF0000"><span class="Estilo3">Precio:</span></td>
        <td><input name="txtPrecio" type="text" id="txtPrecio" size="15" readonly value="<%=pro.getProducto_precio() %>"></td>
      </tr>
      <tr>
        <td bgcolor="#FF0000"><span class="Estilo3">Stock:</span></td>
        <td><input name="txtStock" type="text" id="txtStock" size="15" readonly value="<%=pro.getProducto_stock() %>"></td>
      </tr>
      <tr>
        <td bgcolor="#FF0000"><span class="Estilo3">Cantidad A Agregar:</span></td>
        <td><input name="txtCantidadPedir" type="text" id="txtCantidadPedir" value="1" size="15"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><label>
          <input type="submit" name="button" id="button" value="Registrar">
        </label></td>
      </tr>
    </table>

    </form>

    
</body>
<%}
}%>
</html>
<%}}%>