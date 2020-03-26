package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Conus {
    public static Connection getConnection(){
       String url, username, password;
       url="jdbc:mysql://132.148.26.107:3306/paula";
       username="paula";
       password="n0m3l0";
       Connection con=null;
       try{
          Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(url, username, password);
           System.out.println("Si conecto");
       }catch(Exception e){
           System.out.println("No conecto");
           System.out.println(e.getStackTrace());
           System.out.println(e.getMessage());
       }
        return con;
    }// fin del metodo de conexion
    
    public static int Guardarus(Usuario e){
        int fin=0;
            try{
            /*  List<Usuario> lista=Conus.getAllUsuarios();
                for (Usuario a:lista) {
                    System.out.println(a.getCorreo());
                    System.out.println(a.getUsername());
                    System.out.println(a.getPassword());
                    System.out.println(a.getId_tus());
                    //System.out.println(a.getId_com());
                }*/
                Connection con = Conus.getConnection();
                
                 String q="insert into musuario"
                    + "(nom_us,con_us,cor_us,id_tus,id_com)"
                    + " values(?,?,?,?,?)"; 
                PreparedStatement set=con.prepareStatement(q);
                    
                set.setString(1, e.getUsername());
                set.setString(2, e.getPassword());
                set.setString(3, e.getCorreo());
                set.setInt(4, e.getId_tus()); 
                set.setInt(5, e.getId_com());
                
                fin=set.executeUpdate();
                
                con.close(); 
                
            }catch(Exception f){
                System.out.println("No conectó a la base de datosguardarus");
            }
        return fin; 
    }//acaba el guardar
    
    //vamos a modificar el usuario
    
    public static int Modificarusu(Usuario e){
        int fin=0; 
       
        try{
            Connection con = Conus.getConnection();
            //System.out.println(e.getUsername());
            
            
            if (!"".equals(e.getUsername())) {
                String q="update musuario set nom_us=?"
                    + " where id_us=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setString(1,e.getUsername());
            set.setInt(2,e.getId());
            fin =set.executeUpdate();
            con.close();
            }else if(!"".equals(e.getPassword())){
                String q="update musuario set con_us=?"
                    + " where id_us=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setString(1,e.getPassword());
            set.setInt(2,e.getId());
            fin =set.executeUpdate();
            con.close();
            }else if(e.getId_com()!=0){
                String q="update musuario set id_com=?"
                    + " where id_us=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setInt(1,e.getId_com());
            set.setInt(2,e.getId());
            fin =set.executeUpdate();
            con.close();
            }/**else if(!"".equals(e.getPais())){
                String q="update empleado_datos set pais=?"
                    + " where id=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setString(1,e.getPais());
            set.setInt(2,e.getId());
            fin =set.executeUpdate();
            con.close();
            }
            
           /** String q="update empleado_datos set nombre=?,"
                    + "password=?,"
                    + "email=?,"
                    + "pais=?"
                    + "where id=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setString(1,e.getNombre());
            set.setString(2,e.getPassword());
            set.setString(3,e.getEmail());
            set.setString(4,e.getPais());
            set.setInt(5,e.getId());
            estado =set.executeUpdate();*/
            //con.close();
            
        }catch(Exception d){
            System.out.println("No se conecto a la tabla ");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        
        return fin; 
    }
    
   
    //vamo a buscar si coinciden
    
    public static Usuario getUsuarioByUsername(Usuario e){
        Usuario obj= new Usuario();
        try{
            Connection con= Conus.getConnection(); 
            String q = "select * from musuario where nom_us=? "; 
            PreparedStatement set= con.prepareStatement(q); 
            set.setString(1, e.getUsername());
            ResultSet rs = set.executeQuery();
            
            if (rs.next()) {
                obj.setId(rs.getInt(1));
                obj.setUsername(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setCorreo(rs.getString(4));
                obj.setId_com(rs.getInt(5));
                obj.setId_tus(rs.getInt(6));
            }
            con.close(); 
            
            
        }catch(Exception d){
            System.out.println("No encotró a la personita x2");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        return obj; 
        
        
    }
    
    public Usuario buscarNombrePorId(int idUs){
        Usuario obj= new Usuario();
        try{
            Connection con= Conus.getConnection(); 
            String q = "select * from musuario where id_us=? "; 
            PreparedStatement set= con.prepareStatement(q); 
            set.setInt(1, idUs);
            ResultSet rs = set.executeQuery();
            
            if (rs.next()) {
                obj.setId(rs.getInt(1));
                obj.setUsername(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setCorreo(rs.getString(4));
                obj.setId_com(rs.getInt(5));
                obj.setId_tus(rs.getInt(6));
            }
            con.close(); 
            
            
        }catch(Exception d){
            System.out.println("No encotró a la personita x2");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        return obj; 
        
        
    }
    
    //vamos a hacernos un arraylist para guardar nuestros datos de la base xd
    
    public static List<Usuario> getAllUsuarios(){
        List<Usuario> listausuarios= new ArrayList<Usuario>();
        try{
             Connection con = Conus.getConnection();
             String q = "select * from musuario"; 
            PreparedStatement set= con.prepareStatement(q); 
            ResultSet rs = set.executeQuery();
            while(rs.next()){
            Usuario obj= new Usuario(); 
            obj.setId(rs.getInt(1));
            obj.setUsername(rs.getString(2));
            obj.setPassword(rs.getString(3));
            obj.setCorreo(rs.getString(4));
            obj.setId_com(rs.getInt(5)); 
            obj.setId_tus(rs.getInt(6)); 
            listausuarios.add(obj); 
            }
            
            con.close();
            
        }catch(Exception d){
            System.out.println("No encotró a la personita x5");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        
        return listausuarios; 
    } 
    
    
    
}// fin de la clase de conexion del usuario 
