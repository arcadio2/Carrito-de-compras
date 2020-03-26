package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>SOSIWTBT</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\">\n");
      out.write("  <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"css/mdb.min.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("  \n");
      out.write("  <style>\n");
      out.write("  .fakeimg {\n");
      out.write("    height: 200px;\n");
      out.write("    background: #aaa;\n");
      out.write("  }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");

    /**if(session.getAttribute("user")==null){
    System.out.println("hola");
    response.sendRedirect("index.html"); 
}**/


      out.write("\n");
      out.write("<div class=\"jumbotron text-center\" style=\"margin-bottom:0\">\n");
      out.write("  <img src=\"img/logo.PNG\" class=\"img-responsive\">\n");
      out.write("  <p>by S.O.S.Ware</p> \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<nav class=\"mb-1 navbar navbar-expand-lg navbar-dark default-color\">\n");
      out.write("  <a class=\"navbar-brand\" href=\"index.jsp\">Suit Style</a>\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent-333\"\n");
      out.write("    aria-controls=\"navbarSupportedContent-333\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent-333\">\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"index.jsp\">Inicio\n");
      out.write("          <span class=\"sr-only\">(actual)</span>\n");
      out.write("        </a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdownMenuLink-333\" data-toggle=\"dropdown\"\n");
      out.write("          aria-haspopup=\"true\" aria-expanded=\"false\">Clóset\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu dropdown-default\" aria-labelledby=\"navbarDropdownMenuLink-333\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"MostrarTrajes.jsp\">Mi Clóset</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"MostrarTrajesCompartidos.jsp\">Publicaciones</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    </ul>\n");
      out.write("    <ul class=\"navbar-nav ml-auto nav-flex-icons\">\n");
      out.write("      \n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdownMenuLink-333\" data-toggle=\"dropdown\"\n");
      out.write("          aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          <i class=\"fas fa-user\"></i>\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu dropdown-menu-right dropdown-default\"\n");
      out.write("          aria-labelledby=\"navbarDropdownMenuLink-333\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"Iniciarsesion.html\">Iniciar sesión</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"Registro.html\">Registrarse</a>\n");
      out.write("         \n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"carousel-example-1z\" class=\"carousel slide carousel-fade\" data-ride=\"carousel\">\n");
      out.write("  <ol class=\"carousel-indicators\">\n");
      out.write("    <li data-target=\"#carousel-example-1z\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("    <li data-target=\"#carousel-example-1z\" data-slide-to=\"1\"></li>\n");
      out.write("    <li data-target=\"#carousel-example-1z\" data-slide-to=\"2\"></li>\n");
      out.write("  </ol>\n");
      out.write("  <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("    <div class=\"carousel-item active\">\n");
      out.write("      <img class=\"d-block w-100\" src=\"img/carousel1.jpg\" alt=\"First slide\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img class=\"d-block w-100\" src=\"img/carousel2.jpg\" alt=\"Second slide\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img class=\"d-block w-100\" src=\"img/carousel3.png\" alt=\"Third slide\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <a class=\"carousel-control-prev\" href=\"#carousel-example-1z\" role=\"button\" data-slide=\"prev\">\n");
      out.write("    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"sr-only\">Anterior</span>\n");
      out.write("  </a>\n");
      out.write("  <a class=\"carousel-control-next\" href=\"#carousel-example-1z\" role=\"button\" data-slide=\"next\">\n");
      out.write("    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"sr-only\">Siguiente</span>\n");
      out.write("  </a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<footer class=\"page-footer font-small brown\" >\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12 py-1\">\n");
      out.write("          <div class=\"mb-5 flex-center\">\n");
      out.write("            <a class=\"fb-ic\" href=\"#\">\n");
      out.write("              <i class=\"fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x\"> </i>\n");
      out.write("            </a>\n");
      out.write("            <a class=\"tw-ic\" href=\"#\">\n");
      out.write("              <i class=\"fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x\"> </i>\n");
      out.write("            </a>\n");
      out.write("            <a class=\"email-ic\">\n");
      out.write("            \t<i class=\"fas fa-at fa-lg white-text mr-md-5 mr-3 fa-2x\" data-toggle=\"collapse\" data-target=\"#mail\"></i>\n");
      out.write("            \t\n");
      out.write("            </a>\n");
      out.write("            <div id=\"mail\" class=\"collapse mr-md-3\">sosware@gmail.com</div>\n");
      out.write("            <a class=\"tel-ic\" href=\"#\">\n");
      out.write("            \t<i class=\"fas fa-phone fa-lg white-text mr-md-5 mr-3 fa-2x\" data-toggle=\"collapse\" data-target=\"#tel\"></i>\n");
      out.write("            \t\n");
      out.write("\n");
      out.write("            </a>\n");
      out.write("            <div id=\"tel\" class=\"collapse\">   55-XXXXXXXX</div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("         </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer-copyright text-center py-3\">© 2019 Copyright: \n");
      out.write("      <a href=\"#\"> Sosware</a>\n");
      out.write("    </div>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
