<%-- 
    Document   : index
    Created on : 23/04/2019, 09:25:01 PM
    Author     : arcad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page session="true" %>
<%
    //para eliminar el chaché
    //pero esto se envia a un jsp xd
   /** response.setHeader("Pragma", "no-cahce");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    try{
    if(session.getAttribute("user")==null){
        request.getRequestDispatcher("indes.html").forward(request, response); 
    }
    }catch(Exception e){
         request.getRequestDispatcher("indes.html").forward(request, response);
    }*/
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>SOSIWTBT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/mdb.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>
<%
    if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}

%>


<nav class="mb-1 navbar navbar-expand-lg navbar-dark default-color">
  <a class="navbar-brand" href="index.jsp">Suit Style</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
    aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Inicio
          <span class="sr-only">(actual)</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MostrarCamisas.jsp">Outfit
          
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">Clóset
        </a>
        <div class="dropdown-menu dropdown-default" aria-labelledby="navbarDropdownMenuLink-333">
          <a class="dropdown-item" href="MostrarTrajes.jsp">Mi Clóset</a>
          <a class="dropdown-item" href="MostrarTrajesCompartidos.jsp">Publicaciones</a>
          
        </div>
      </li>
      
      
    </ul>
    <ul class="navbar-nav ml-auto nav-flex-icons">
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user"><%=session.getAttribute("user")%></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right dropdown-default"
          aria-labelledby="navbarDropdownMenuLink-333">
          <a class="dropdown-item" href="Editar.jsp">Mi Cuenta</a>
          <a class="dropdown-item" href="Cerrarsesionusu">Cerrar sesión</a>
         
        </div>
      </li>
    </ul>
  </div>
</nav>


<div id="carousel-example-1z" class="carousel slide carousel-fade" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-1z" data-slide-to="1"></li>
    <li data-target="#carousel-example-1z" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
      <img class="d-block w-100" src="img/carousel1.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/carousel2.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/carousel3.png" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Anterior</span>
  </a>
  <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Siguiente</span>
  </a>
</div>

<footer class="page-footer font-small brown" >
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