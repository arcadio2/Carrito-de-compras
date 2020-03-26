package Controlador;

import Controlador.Conexion;
import Controlador.Conexion;
import Controlador.Conexion;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * @autor 
 * Archivo: Producto.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Rostro{

	private int id_ros;
	private String cla_ros;
	
	

	/** Crea un nueva instancia de la clase producto */
	public Rostro(){

	}

   

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Rostro> listaRostros(){//Con magia de sirenas :D
        Vector<Rostro> lr=new Vector<Rostro>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM crostro";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Rostro ros=new Rostro();
                ros.setRostro_id(rs.getInt("id_ros"));
                ros.setRostro_clasificacion(rs.getString("cla_ros"));
                
               
                lr.add(ros);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lr=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lr;
    }
    
    
    

	public int getRostro_id(){
		 return this.id_ros;
	}
	public String getRostro_clasificacion(){
		 return this.cla_ros;
	}
	
	

	
	public void setRostro_id(int id_ros){
		 this.id_ros=id_ros;
	}
	public void setRostro_clasificacion(String cla_ros){
		 this.cla_ros=cla_ros;
	}
	
	

}

