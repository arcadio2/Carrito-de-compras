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
public class Camisa{

	private int id_cam;
	private String des_cam;
	private String url_cam;
	

	/** Crea un nueva instancia de la clase producto */
	public Camisa(){

	}

   

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Camisa> listaCamisas(){//Con magia de sirenas :D
        Vector<Camisa> lc=new Vector<Camisa>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mcamisa";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Camisa cam=new Camisa();
                cam.setCamisa_id(rs.getInt("id_cam"));
                cam.setCamisa_descripcion(rs.getString("des_cam"));
                cam.setCamisa_imagen(rs.getString("url_cam"));
               
                lc.add(cam);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lc=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lc;
    }

    /**
     * Metodo utilizado para buscar un producto por codigo
     * @param idCamisa
     * @param codigoProducto Representa el codigo del producto que vamos a buscar
     * @return Retorna un producto buscado por el codigo
     */
   public Camisa buscarCamisa(int idCamisa){
        Camisa cam=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mcamisa WHERE id_cam=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idCamisa);
            rs=pr.executeQuery();
            while(rs.next()){
                cam=new Camisa();
                cam.setCamisa_id(rs.getInt("id_cam"));
                cam.setCamisa_descripcion(rs.getString("des_cam"));
                cam.setCamisa_imagen(rs.getString("url_cam"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            cam=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return cam;
    }


	/** Metodos GET de la clase producto
     * @return  */
	public int getCamisa_id(){
		 return this.id_cam;
	}
	public String getCamisa_descripcion(){
		 return this.des_cam;
	}
	public String getCamisa_imagen(){
		 return this.url_cam;
	}
	

	/** Metodos SET de la clase producto
     * @param camisa_Id */

	public void setCamisa_id(int id_cam){
		 this.id_cam=id_cam;
	}
	public void setCamisa_descripcion(String des_cam){
		 this.des_cam=des_cam;
	}
	public void setCamisa_imagen(String url_cam){
		 this.url_cam=url_cam;
	}
	

}

