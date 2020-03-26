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
public class Zapato{

	private int id_zap;
	private String des_zap;
	private String url_zap;
	

	/** Crea un nueva instancia de la clase producto */
	public Zapato(){

	}

   

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Zapato> listaZapatos(){//Con magia de sirenas :D
        Vector<Zapato> lz=new Vector<Zapato>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mzapato";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Zapato zap=new Zapato();
                zap.setZapato_id(rs.getInt("id_zap"));
                zap.setZapato_descripcion(rs.getString("des_zap"));
                zap.setZapato_imagen(rs.getString("url_zap"));
               
                lz.add(zap);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lz=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lz;
    }

    /**
     * Metodo utilizado para buscar un producto por codigo
     * @param idCamisa
     * @param codigoProducto Representa el codigo del producto que vamos a buscar
     * @return Retorna un producto buscado por el codigo
     */
   public Zapato buscarZapato(int idZapato){
        Zapato zap=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mzapato WHERE id_zap=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idZapato);
            rs=pr.executeQuery();
            while(rs.next()){
                zap=new Zapato();
                zap.setZapato_id(rs.getInt("id_zap"));
                zap.setZapato_descripcion(rs.getString("des_zap"));
                zap.setZapato_imagen(rs.getString("url_zap"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            zap=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return zap;
    }


	/** Metodos GET de la clase producto
     * @return  */
	public int getZapato_id(){
		 return this.id_zap;
	}
	public String getZapato_descripcion(){
		 return this.des_zap;
	}
	public String getZapato_imagen(){
		 return this.url_zap;
	}
	

	/** Metodos SET de la clase producto
     * @param camisa_Id */

	public void setZapato_id(int id_cam){
		 this.id_zap=id_cam;
	}
	public void setZapato_descripcion(String des_cam){
		 this.des_zap=des_cam;
	}
	public void setZapato_imagen(String url_cam){
		 this.url_zap=url_cam;
	}
	

}

