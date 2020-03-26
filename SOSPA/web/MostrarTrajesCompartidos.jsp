<%@page import="Controlador.Conus"%>
<%@page import="Controlador.Corbata"%>
<%@page import="Controlador.Pantalon"%>
<%@page import="Controlador.Zapato"%>
<%@page import="Controlador.Guardarropa"%>
<%@page import="Controlador.Saco"%>
<%@page import="Controlador.Camisa"%>
<%@page import="Controlador.Traje"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>

    <%
        
        Vector<Traje> vecTra=new Traje().listaTrajesCompartidos();
        Camisa cam=new Camisa();
        Saco sac=new Saco();
        Corbata cor=new Corbata();
        Pantalon pan=new Pantalon();
        Zapato zap=new Zapato();
        Guardarropa gua=new Guardarropa();
        Conus con=new Conus();
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        <a class="nav-link" href="Iniciarsesion.html">Cuenta</a>
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



    <%
            for(Traje tra:vecTra){
              String agregar;
              String agregartxt;
              
               if(gua.buscarGuardarropa(tra.getTraje_id()).getFavorito_id()==1){
                   agregar="glyphicon glyphicon-plus";
                   agregartxt="Agregar";
               }else{
                   agregar="glyphicon glyphicon-minus";
                   agregartxt="Quitar";
               }
               
               
          %>
<section class="section-content bg padding-y-sm">
<div class="container">


<div class="row">
<div class="col-xl-10 col-md-9 col-sm-12">


<main class="card">
	<div class="row no-gutters">
		<aside class="col-sm-6 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
  <div>  <a href="<%=sac.buscarSaco(tra.getTrajeSaco_id()).getSaco_imagen()%>" data-fancybox=""><img src="<%=sac.buscarSaco(tra.getTrajeSaco_id()).getSaco_imagen()%>"></a></div>
</div> <!-- slider-product.// -->
<div class="img-small-wrap">
  <div class="item-gallery" ><a href="<%=cam.buscarCamisa(tra.getTrajeCamisa_id()).getCamisa_imagen()%>" data-fancybox=""> <img src="<%=cam.buscarCamisa(tra.getTrajeCamisa_id()).getCamisa_imagen()%>"></a></div>
  <div class="item-gallery" ><a href="<%=pan.buscarPantalon(tra.getTrajePantalon_id()).getPantalon_imagen()%>" data-fancybox=""> <img src="<%=pan.buscarPantalon(tra.getTrajePantalon_id()).getPantalon_imagen()%>"></a></div>
  <div class="item-gallery" ><a href="<%=cor.buscarCorbata(tra.getTrajeCorbata_id()).getCorbata_imagen()%>" data-fancybox=""> <img src="<%=cor.buscarCorbata(tra.getTrajeCorbata_id()).getCorbata_imagen()%>"></a></div>
  <div class="item-gallery" ><a href="<%=zap.buscarZapato(tra.getTrajeZapato_id()).getZapato_imagen()%>" data-fancybox=""> <img src="<%=zap.buscarZapato(tra.getTrajeZapato_id()).getZapato_imagen()%>"></a></div>
</div> <!-- slider-nav.// -->
</article> <!-- gallery-wrap .end// -->
		</aside>
		<aside class="col-sm-6">
<article class="card-body">
<!-- short-info-wrap -->
	<h3 class="title mb-3">Nombre del traje:</h3>
        
        <div class="mb-3"> 
	
            <span ><h4 class="title mb-3"><%=tra.getTraje_nombre()%></h4></span>
            
</div>
            <h3 class="title mb-3">Dueño del traje:</h3>
        
        <div class="mb-3"> 
	
            <span ><h4 class="title mb-3"><%=con.buscarNombrePorId(gua.buscarGuardarropa(tra.getTraje_id()).getUsuario_id()).getUsername()%></h4></span>
                
</div>

		<input class="form-control" name="txtNomTra" type="hidden" id="txtNomTra" readonly="readonly" value="<%=tra.getTraje_nombre()%>">
                <!-- price-detail-wrap .// --><br>
<dl>
  <dt>Descripción del Traje</dt>
  <dd><br> 
      <p>Saco: <%=sac.buscarSaco(tra.getTrajeSaco_id()).getSaco_descripcion()%> </p>
      <p>Camisa: <%=cam.buscarCamisa(tra.getTrajeCamisa_id()).getCamisa_descripcion()%></p>
      <p>Pantalon: <%=pan.buscarPantalon(tra.getTrajePantalon_id()).getPantalon_descripcion()%></p>
      <p>Corbata: <%=cor.buscarCorbata(tra.getTrajeCorbata_id()).getCorbata_descripcion()%></p>
      <p>Zapatos: <%=zap.buscarZapato(tra.getTrajeZapato_id()).getZapato_descripcion()%></p></dd>
</dl>

	<hr>
        <form name="formtrajecompartido" action="SAgregarTrajeCompartido" method="get">
                <button type="submit" class="btn btn-default btn-lg" >
                    <input type="hidden" name="idTraf" id="idTraf" value="<%=tra.getTraje_id()%>">
                    <span class="<%=agregar%>" aria-hidden="true"></span><%=agregartxt%>
                </button>
        </form>
                <br>
                
	
</article>
		</aside> 
	</div>
</main> 
</div> 
</div> 
</div>
</section>
<%}%>

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