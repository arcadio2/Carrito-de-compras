package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ConexionUsuario {
    
    public static Connection obtenerconexion(){
        final String url, password, username; 
        url="jdbc:mysql://localhost:3306/carrito"; 
        password="n0m3l0"; 
        username="root";
        Connection con=null; 
        try{
         Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(url, username, password);
        }catch(Exception s){
             System.out.println("Error de conexión a la base de datos");
        }
        
        
        return con; 
    }//fin  de la conexióm
    
    public static boolean RegistroUsuarios(EUsuario e){
    boolean test = false; 
    Connection con=null; 
    //final int id=2; 
    PreparedStatement set = null; 
        try {
            System.out.println(e.getContraseña() +" "+e.getCorreo()+" "+ e.getUsuario() + " "+e.getUltimasesion());
            con = ConexionUsuario.obtenerconexion(); 
            String  q="call registrar(?,?,?,?,?)";
            set = con.prepareStatement(q); 
            set.setString(1, e.getUsuario());
            set.setString(2, e.getCorreo());
          //  set.setString(3, e.getContraseña()); 
            set.setString(3, e.getContraseña());
             set.setInt(4, 2);
            set.setString(5, e.getUltimasesion()); 
           
            int a=set.executeUpdate(); 
            if (a>0) {
                test=true;
                System.out.println("Registro completamente exitoso");
            }else{
                test=false; 
                System.out.println("ocurrió un error que no es en la conexión");
            }
          
        }catch(Exception a ){
            System.out.println("No registró por error");
            System.out.println(a.getMessage());
            
        }finally{
            
            try{
                   con.close();
                   set.close(); 
                 if (obtenerconexion() != null) obtenerconexion().close(); 
                
            }catch(Exception as){
                
            }
            
        }
        return test;
    }
    
    public static List<EUsuario> getAllUsuarios(){
        List<EUsuario> o = new ArrayList<>(); 
        
        try{
             Connection con = ConexionUsuario.obtenerconexion();
             String q = "select * from usuario"; 
            PreparedStatement set= con.prepareStatement(q); 
            ResultSet rs = set.executeQuery();
            while(rs.next()){
            EUsuario obj= new EUsuario(); 
            obj.setId(rs.getInt(1));
            obj.setUsuario(rs.getString(2));
            obj.setCorreo(rs.getString(3));
            obj.setContraseña(rs.getString(4));
            obj.setId_tus(rs.getInt(5)); 
            o.add(obj); 
            }
            
            con.close();
            
        }catch(Exception d){
            System.out.println("No encotró a la personita x5");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        
        return o; 
    } 
    
 
    
    public static EUsuario getAllByUsername(EUsuario e){
         EUsuario obj= new EUsuario();
        try{
            Connection con= ConexionUsuario.obtenerconexion(); 
            String q = "call getByUsername(?)"; 
            PreparedStatement set= con.prepareStatement(q); 
            set.setString(1, e.getUsuario());
            ResultSet rs = set.executeQuery();
            
            if (rs.next()) {
                obj.setId(rs.getInt(1));
                obj.setUsuario(rs.getString(2));
                obj.setCorreo(rs.getString(3));
                obj.setContraseña(rs.getString(4));
                obj.setId_tus(rs.getInt(5));
               // obj.getUltimasesion(rs.getString(6));
            }
            con.close(); 
            
            
        }catch(Exception d){
            System.out.println("No encotró a la personita x2");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        return obj; 
        
        
    }
    
    public static boolean cambiar(EUsuario e){
        boolean test=false; 
        
        try{
            Connection con = ConexionUsuario.obtenerconexion();
            System.out.println(e.getUsuario());
            
            
            if (!"".equals(e.getUsuario())) {
                String q="update usuario set nom_us=?"
                    + " where id_us=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setString(1,e.getUsuario());
            set.setInt(2,e.getId());
            int fin =set.executeUpdate();
                if (fin>0) {
                    test=true; 
                }else{
                test=false; 
                }
            con.close();
            }else if(!"".equals(e.getContraseña())){
                String q="update usuario set con_us=?"
                    + " where id_us=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setString(1,e.getContraseña());
            set.setInt(2,e.getId());
            int fin =set.executeUpdate();
                if (fin>0) {
                    test=true; 
                }else{
                    test=false; 
                }
            con.close();
            }
        }catch(Exception d){
            System.out.println("No se conecto a la tabla ");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        
        return test; 
    }
    
    public static boolean RegistroEmpleado(EUsuario e){ 
        boolean test = false; 
         Connection con=null; 
    //final int id=2; 
    PreparedStatement set = null; 
        try {
            System.out.println(e.getContraseña() +" "+e.getCorreo()+" "+ e.getUsuario() + " "+e.getUltimasesion());
            con = ConexionUsuario.obtenerconexion(); 
            String  q="call registrar(?,?,?,?,?)";
            set = con.prepareStatement(q); 
            set.setString(1, e.getUsuario());
            set.setString(2, e.getCorreo());
          //  set.setString(3, e.getContraseña()); 
            set.setString(3, e.getContraseña());
             set.setInt(4, e.getId_tus());
            set.setString(5, e.getUltimasesion()); 
           
            int a=set.executeUpdate(); 
            if (a>0) {
                test=true;
                System.out.println("Registro completamente exitoso");
            }else{
                test=false; 
                System.out.println("ocurrió un error que no es en la conexión");
            }
          
        }catch(Exception a ){
            System.out.println("No registró por error");
            System.out.println(a.getMessage());
            
        }finally{
            
            try{
                   con.close();
                   set.close(); 
                 if (obtenerconexion() != null) obtenerconexion().close(); 
                
            }catch(Exception as){
                
            }
            
        }
        
        return test; 
    }
    
        
    public static ID getAllById(ID e){
         ID obj= new ID();
        try{
            
            Connection con= ConexionUsuario.obtenerconexion(); 
            String q = "select * from usuario where id_us=?"; 
            PreparedStatement set= con.prepareStatement(q); 
            set.setInt(1, e.getId());
            ResultSet rs = set.executeQuery();
            
            if (rs.next()) {
                obj.setId(rs.getInt(1));
                obj.setUsuario(rs.getString(2));
                obj.setCorreo(rs.getString(3));
                obj.setContraseña(rs.getString(4));
                obj.setId_tus(rs.getInt(5));
               // obj.getUltimasesion(rs.getString(6));
            }
            con.close(); 
            
            
        }catch(Exception d){
            System.out.println("No encotró a la personita x2");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        return obj; 
        
        
    }
    
    
    
}
