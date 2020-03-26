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
public class Saco{

	private int id_sac;
	private String des_sac;
	private String url_sac;
	

	/** Crea un nueva instancia de la clase producto */
	public Saco(){

	}

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Saco> listaSacos(){//Con magia de sirenas :D
        Vector<Saco> ls=new Vector<Saco>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM msaco";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Saco sac=new Saco();
                sac.setSaco_id(rs.getInt("id_sac"));
                sac.setSaco_descripcion(rs.getString("des_sac"));
                sac.setSaco_imagen(rs.getString("url_sac"));
               
                ls.add(sac);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            ls=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return ls;
    }

    /**
     * Metodo utilizado para buscar un producto por codigo
     * @param codigoProducto Representa el codigo del producto que vamos a buscar
     * @return Retorna un producto buscado por el codigo
     */
   public Saco buscarSaco(int idSaco){
        Saco sac=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM msaco WHERE id_sac=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idSaco);
            rs=pr.executeQuery();
            while(rs.next()){
                sac=new Saco();
                sac.setSaco_id(rs.getInt("id_sac"));
                sac.setSaco_descripcion(rs.getString("des_sac"));
                sac.setSaco_imagen(rs.getString("url_sac"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            sac=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return sac;
    }

  


	/** Metodos GET de la clase producto
     * @return  */
	public int getSaco_id(){
		 return this.id_sac;
	}
	public String getSaco_descripcion(){
		 return this.des_sac;
	}
	public String getSaco_imagen(){
		 return this.url_sac;
	}
	

	/** Metodos SET de la clase producto
      */

	public void setSaco_id(int id_sac){
		 this.id_sac=id_sac;
	}
	public void setSaco_descripcion(String des_sac){
		 this.des_sac=des_sac;
	}
	public void setSaco_imagen(String url_sac){
		 this.url_sac=url_sac;
	}
	

}

