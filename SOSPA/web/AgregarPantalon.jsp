<%@page import="Controlador.Pantalon"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>

   <%
    Vector<Pantalon> vecPan=new Pantalon().listaPantalones();
    boolean compare=false; 
    int id_pa=Integer.parseInt(request.getParameter("id"));    
   Pantalon pan=new Pantalon().buscarPantalon(id_pa);
   
    for (Pantalon a:vecPan) {
            if (a.getPantalon_id()==id_pa) {
                    compare=true; 
                    break; 
                }
        }
    
        if (compare==true) {
                
            
   
    %>
    <%
if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}

%>
<%-- Finalizar --%>

<html>
<head>
<title>.:PAW-Agregar Productos</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">

<!-- jQuery -->
<script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap4 files-->
<script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/fontawesome-all.min.css" type="text/css" rel="stylesheet">

<!-- plugin: fancybox  -->
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/fancybox/fancybox.min.css" rel="stylesheet" type="text/css"/>
<script src="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/fancybox/fancybox.min.js" type="text/javascript"></script>
<!-- plugin: owl carousel  -->
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" type="text/css"/>
<script src="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/owlcarousel/owl.carousel.min.js" type="text/javascript"></script>
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.theme.default.css" rel="stylesheet" type="text/css"/>
<!-- custom style -->
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/ui.css" rel="stylesheet" type="text/css"/>

<link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/responsive.css" rel="stylesheet" media="only screen and (max-width: 1200px)"/>
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
    <form name="frmPan" action="SAgregarPantalon"  method="post">
    <section class="section-content bg padding-y-sm">
<div class="container">


<div class="row">
<div class="col-xl-10 col-md-9 col-sm-12">


<main class="card">
	<div class="row no-gutters">
		<aside class="col-sm-6 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
    <div> <a href="<%=pan.getPantalon_imagen()%>" data-fancybox=""><img src="<%=pan.getPantalon_imagen()%>">
        <input name="txtImagen" type="hidden" id="txtImagen" size="1" readonly value="<%=pan.getPantalon_imagen()%>" >
        </a></div>
</div>
</article> 
		</aside>
		<aside class="col-sm-6">
<article class="card-body">

	<h3 class="title mb-3"><input name="txtDescripcion" type="text" id="txtDescripcion" size="10" readonly value="<%=pan.getPantalon_descripcion()%>" ></h3>

        <input name="txtId" type="hidden" id="txtId" size="1" readonly value="<%=pan.getPantalon_id()%>" >
	<hr>
	<input class="btn  btn-warning" type="submit" name="button" id="button" value="Confirmar">
	<a href="MostrarPantalones.jsp" class="btn  btn-outline-warning"> Regresar </a>
</article>
		</aside> 
	</div>
</main> 
</section>

    </form>
    <%}else{
    response.sendRedirect("MostrarPantalones.jsp");
    }
    
    %>
</body>
</html>