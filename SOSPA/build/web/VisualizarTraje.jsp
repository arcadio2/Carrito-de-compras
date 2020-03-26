<%@page import="Controlador.Zapato"%>
<%@page import="Controlador.Saco"%>
<%@page import="Controlador.Pantalon"%>
<%@page import="Controlador.Corbata"%>
<%@page import="Controlador.Camisa"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>

<html>
<head>
<title>.:PAW-Consultar Productos</title>
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
    <%
if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}

%>
    <form name="frmTraje" action="SFinalizarTraje"  method="post">
<%
             int idUs = (Integer) session.getAttribute("Id");
             int idCamisa = (Integer) session.getAttribute("MiCamisa");
             int idSaco = (Integer) session.getAttribute("MiSaco");
             int idPantalon = (Integer) session.getAttribute("MiPantalon");
             int idCorbata = (Integer) session.getAttribute("MiCorbata");
             int idZapato= (Integer) session.getAttribute("MiZapato");
             Camisa cam=new Camisa().buscarCamisa(idCamisa);
             Corbata cor=new Corbata().buscarCorbata(idCorbata);
             Pantalon pan=new Pantalon().buscarPantalon(idPantalon);
             Saco sac=new Saco().buscarSaco(idSaco);
             Zapato zap=new Zapato().buscarZapato(idZapato);
          %>
  
    <table>
        <input name="txtIdCamisa" type="hidden" id="txtIdCamisa" size="1" readonly value="<%=cam.getCamisa_id()%>" >
        <input name="txtIdSaco" type="hidden" id="txtIdSaco" size="1" readonly value="<%=sac.getSaco_id()%>" >
        <input name="txtIdPantalon" type="hidden" id="txtIdPantalon" size="1" readonly value="<%=pan.getPantalon_id()%>" >
        <input name="txtIdCorbata" type="hidden" id="txtIdCorbata" size="1" readonly value="<%=cor.getCorbata_id()%>" >
        <input name="txtIdZapato" type="hidden" id="txtIdZapato" size="1" readonly value="<%=zap.getZapato_id()%>" >
        <input name="txtIdUs" type="hidden" id="txtIdUs" size="1" readonly value="<%=idUs%>" >
      
        </table>
        
        <section class="section-content bg padding-y-sm">
<div class="container">


<div class="row">
<div class="col-xl-10 col-md-9 col-sm-12">


<main class="card">
	<div class="row no-gutters">
		<aside class="col-sm-6 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
  <div>  <a href="<%=sac.getSaco_imagen()%>" data-fancybox=""><img src="<%=sac.getSaco_imagen()%>"></a></div>
</div> <!-- slider-product.// -->
<div class="img-small-wrap">
  <div class="item-gallery" ><a href="<%=cam.getCamisa_imagen()%>" data-fancybox=""> <img src="<%=cam.getCamisa_imagen()%>"></a></div>
  <div class="item-gallery" ><a href="<%=pan.getPantalon_imagen()%>" data-fancybox=""> <img src="<%=pan.getPantalon_imagen()%>"></a></div>
  <div class="item-gallery" ><a href="<%=cor.getCorbata_imagen()%>" data-fancybox=""> <img src="<%=cor.getCorbata_imagen()%>"></a></div>
  <div class="item-gallery" ><a href="<%=zap.getZapato_imagen()%>" data-fancybox=""> <img src="<%=zap.getZapato_imagen()%>"></a></div>
</div> <!-- slider-nav.// -->
</article> <!-- gallery-wrap .end// -->
		</aside>
		<aside class="col-sm-6">
<article class="card-body">
<!-- short-info-wrap -->
	<h3 class="title mb-3">Dale un nombre a tu traje:</h3>

<div class="mb-3"> 
	<var class="price h3 text-warning"> 
		<input class="form-control" name="txtNomTra" type="text" id="txtNomTra">
	</var> 
	
</div> <!-- price-detail-wrap .// -->
<dl>
  <dt>Descripción del Traje</dt>
  <dd><br> 
      <p>Saco: <%=sac.getSaco_descripcion()%> <a class="btn btn-primary" href="CambiarSaco.jsp" role="button">Cambiar Saco</a></p>
      <p>Camisa: <%=cam.getCamisa_descripcion()%> <a class="btn btn-primary" href="CambiarCamisa.jsp" role="button">Cambiar Camisa</a></p>
      <p>Pantalon: <%=pan.getPantalon_descripcion()%> <a class="btn btn-primary" href="CambiarPantalon.jsp" role="button">Cambiar Pantalon</a></p>
      <p>Corbata: <%=cor.getCorbata_descripcion()%> <a class="btn btn-primary" href="CambiarCorbata.jsp" role="button">Cambiar Corbata</a></p>
      <p>Zapatos: <%=zap.getZapato_descripcion()%> <a class="btn btn-primary" href="CambiarZapato.jsp" role="button">Cambiar Zapatos</a></p></dd>
</dl>

	<hr>
	 <input class="btn  btn-primary" type="submit" name="button" id="button" value="Terminar Traje">
</article>
		</aside> 
	</div>
</main> 
</div> 
</div> 
</div>
</section>
	
            
            
    </form>
</body>
</html>
