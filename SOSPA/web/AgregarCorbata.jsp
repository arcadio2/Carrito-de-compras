
<%@page import="Controlador.Corbata"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>



    <%
        Vector<Corbata> vecCor=new Corbata().listaCorbatas();
        boolean compare=false; 
        int id_cor=Integer.parseInt(request.getParameter("id")); 
        
        for(Corbata a:vecCor){
            if (id_cor==a.getCorbata_id()) {
                    compare=true; 
                    break; 
                }
        }
        if (compare==true) {
                
           
   Corbata cor=new Corbata().buscarCorbata(id_cor);
   
    %>
    <%
if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}

%>


<html>
<head>
<title>.:PAW-Agregar Productos</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">

<script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/jquery-2.0.0.min.js" type="text/javascript"></script>

<script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/bootstrap.css" rel="stylesheet" type="text/css"/>

<link href="fonts/fontawesome/css/fontawesome-all.min.css" type="text/css" rel="stylesheet">

<link href="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/fancybox/fancybox.min.css" rel="stylesheet" type="text/css"/>
<script src="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/fancybox/fancybox.min.js" type="text/javascript"></script>

<link href="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" type="text/css"/>
<script src="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/owlcarousel/owl.carousel.min.js" type="text/javascript"></script>
<link href="bootstrap-ecommerce-uikit/ui-ecommerce/plugins/owlcarousel/assets/owl.theme.default.css" rel="stylesheet" type="text/css"/>

<link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/ui.css" rel="stylesheet" type="text/css"/>

<link href="bootstrap-ecommerce-uikit/ui-ecommerce/css/responsive.css" rel="stylesheet" media="only screen and (max-width: 1200px)"/>


<script src="bootstrap-ecommerce-uikit/ui-ecommerce/js/script.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function() {
	
}); 

</script>
  
</head>
<body>
    <form name="frmCorbata" action="SAgregarCorbata"  method="post">
    <section class="section-content bg padding-y-sm">
<div class="container">


<div class="row">
<div class="col-xl-10 col-md-9 col-sm-12">


<main class="card">
	<div class="row no-gutters">
		<aside class="col-sm-6 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
    <div> <a href="<%=cor.getCorbata_imagen()%>" data-fancybox=""><img src="<%=cor.getCorbata_imagen()%>">
        <input name="txtImagen" type="hidden" id="txtImagen" size="1" readonly value="<%=cor.getCorbata_imagen()%>" >
        </a></div>
</div>
</article> 
		</aside>
		<aside class="col-sm-6">
<article class="card-body">

	<h3 class="title mb-3"><input name="txtDescripcion" type="text" id="txtDescripcion" size="10" readonly value="<%=cor.getCorbata_descripcion()%>" ></h3>

        <input name="txtId" type="hidden" id="txtId" size="1" readonly value="<%=cor.getCorbata_id()%>" >
	<hr>
	<input class="btn  btn-warning" type="submit" name="button" id="button" value="Confirmar">
	<a href="MostrarCorbatas.jsp" class="btn  btn-outline-warning"> Regresar </a>
</article>
		</aside> 
	</div>
</main> 
</section>

    </form>
    <% }else{
    response.sendRedirect("MostrarCorbatas.jsp");
}%>
</body>
</html>