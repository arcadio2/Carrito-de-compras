package Servlets;
import Controlador.*; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registro extends HttpServlet {


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Aqui yte registras</title>");            
            out.println("</head>");
            out.println("<body>");
            List<Usuario> lista=Conus.getAllUsuarios();
            String usuario, password, correo, com; 
            int id_com = 0; 
            boolean compus=true; 
            final int id_tus=2; 
            usuario=request.getParameter("nomus");
            password=request.getParameter("password"); 
            correo=request.getParameter("email"); 
            com=request.getParameter("com"); 
             if (com.equals("Ectomorfo")) {
                 id_com=1; 
             }else if(com.equals("Mesomorfo")){
                 id_com=2; 
             }else if(com.equals("Endomorfo")){ 
                 id_com=3; 
             }else{
                 System.out.println("no");
             }
             for(Usuario a:lista){
                 if (usuario.equals(a.getUsername())) {
                     compus=false; 
                 }
             }
            
             if ("".equals(usuario) || "".equals(password) || "".equals(correo) || "".equals(com)) {
                 out.println("Pues no te pudimos registrar compa"); 

             }//fin del if de los nulos
             else{
                 if (compus==false) {
                     //aqui nos vamos a hechar un ajax xd
                     System.out.println("Mijo, esta repetido");
                 }else{
                      Usuario obj=new Usuario(); 
            
            obj.setUsername(usuario);
            obj.setCorreo(correo);
            obj.setPassword(password);
            obj.setId_com(id_com); 
            obj.setId_tus(id_tus);
            int fin=Conus.Guardarus(obj); 
 
            try{
                if (fin>0) {
                    System.out.println("Registrado");
                }else{
                    System.out.println("un pequeño error");
                }
                
            }catch(Exception e){
                System.out.println("no registrado");
            }
                 
                 }//fin del else de comparar los usuarios
            
         }//fin del else de los nulos
             

            
            out.println("<h1>Registrarse</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
