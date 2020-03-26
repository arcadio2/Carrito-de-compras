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
public class Corbata{

	private int id_cor;
	private String des_cor;
	private String url_cor;
	

	/** Crea un nueva instancia de la clase producto */
	public Corbata(){

	}

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Corbata> listaCorbatas(){//Con magia de sirenas :D
        Vector<Corbata> lco=new Vector<Corbata>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mcorbata";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Corbata cor=new Corbata();
                cor.setCorbata_id(rs.getInt("id_cor"));
                cor.setCorbata_descripcion(rs.getString("des_cor"));
                cor.setCorbata_imagen(rs.getString("url_cor"));
               
                lco.add(cor);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lco=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lco;
    }

    /**
     * Metodo utilizado para buscar un producto por codigo
     * @param idCorbata
     * @return Retorna un producto buscado por el codigo
     */
    public Corbata buscarCorbata(int idCorbata){
        Corbata cor=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mcorbata WHERE id_cor=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idCorbata);
            rs=pr.executeQuery();
            while(rs.next()){
                cor=new Corbata();
                cor.setCorbata_id(rs.getInt("id_cor"));
                cor.setCorbata_descripcion(rs.getString("des_cor"));
                cor.setCorbata_imagen(rs.getString("url_cor"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            cor=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return cor;
    }
  

	/** Metodos GET de la clase producto
     * @return  */
	public int getCorbata_id(){
		 return this.id_cor;
	}
	public String getCorbata_descripcion(){
		 return this.des_cor;
	}
	public String getCorbata_imagen(){
		 return this.url_cor;
	}
	

	/** Metodos SET de la clase producto
     * @param id_cor */

	public void setCorbata_id(int id_cor){
		 this.id_cor=id_cor;
	}
	public void setCorbata_descripcion(String des_cor){
		 this.des_cor=des_cor;
	}
	public void setCorbata_imagen(String url_cor){
		 this.url_cor=url_cor;
	}
	

}

