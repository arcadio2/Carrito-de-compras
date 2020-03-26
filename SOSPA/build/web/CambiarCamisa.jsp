<%@page import="Controlador.Camisa"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>

    <%
                       
        Vector<Camisa> vecCam=new Camisa().listaCamisas();
    %>
    <%
if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}

%>

<html>
<head>
  <title>SOSIWTBT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="index.html"><img src="img/logotipo.PNG" height="50"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="Iniciarsesion.html"><%=session.getAttribute("user")%></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Outfit</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Clóset</a>
      </li>    
    </ul>
  </div>  
</nav>
<section class="section-content bg padding-y-sm">
<div class="container">
 <h2 class="h1-responsive font-weight-bold text-center my-5">Camisas</h2>
  <p class="grey-text text-center w-responsive mx-auto mb-5">Nuestro Catálogo de Camisas.</p>
<div class="row-sm">
    <%
            for(Camisa cam:vecCam){
                String direccion="ModificarCamisa.jsp?id=" +cam.getCamisa_id() ;
          %>
<div class="col-md-3 col-sm-6">
	<figure class="card card-product">
		<div class="img-wrap"> 
                    <a href="<%=cam.getCamisa_imagen()%>" data-fancybox=""> <img src="<%=cam.getCamisa_imagen() %>"></a>
                </div>
		<figcaption class="info-wrap ">
			<a href="#" class="title "><%=cam.getCamisa_descripcion() %></a>
			<div class="price-wrap " >
				<span class="price-new"><a href="<%= direccion%>" >Cambiar</a></span>
			</div> 
		</figcaption>
	</figure>
</div>
<%}%>
</div>
</div>
</section>
    <footer class="page-footer font-small cyan darken-3" >
    <div class="container">
      <div class="row">
        <div class="col-md-12 py-1">
          <div class="mb-5 flex-center">
            <a class="fb-ic" href="#">
              <i class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            </a>
            <a class="tw-ic" href="#">
              <i class="fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            </a>
            <a class="email-ic">
              <i class="fas fa-at fa-lg white-text mr-md-5 mr-3 fa-2x" data-toggle="collapse" data-target="#mail"></i>
            </a>
            <div id="mail" class="collapse mr-md-3">sosware@gmail.com</div>
            <a class="tel-ic" href="#">
              <i class="fas fa-phone fa-lg white-text mr-md-5 mr-3 fa-2x" data-toggle="collapse" data-target="#tel"></i>
            </a>
            <div id="tel" class="collapse">   55-XXXXXXXX</div>
          </div>
        </div>
         </div>
    </div>
    <div class="footer-copyright text-center py-3">© 2019 Copyright: 
      <a href="#"> Sosware</a>
    </div>
  </footer>       
</body>
</html>