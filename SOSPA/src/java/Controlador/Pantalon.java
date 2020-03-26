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
public class Pantalon{

	private int id_pan;
	private String des_pan;
	private String url_pan;
	

	/** Crea un nueva instancia de la clase producto */
	public Pantalon(){

	}

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Pantalon> listaPantalones(){//Con magia de sirenas :D
        Vector<Pantalon> lp=new Vector<Pantalon>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mpantalon";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Pantalon pan=new Pantalon();
                pan.setPantalon_id(rs.getInt("id_pan"));
                pan.setPantalon_descripcion(rs.getString("des_pan"));
                pan.setPantalon_imagen(rs.getString("url_pan"));
               
                lp.add(pan);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lp=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lp;
    }

    /**
     * Metodo utilizado para buscar un producto por codigo
     * @param codigoProducto Representa el codigo del producto que vamos a buscar
     * @return Retorna un producto buscado por el codigo
     */
     public Pantalon buscarPantalon(int idPantalon){
        Pantalon pan=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mpantalon WHERE id_pan=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idPantalon);
            rs=pr.executeQuery();
            while(rs.next()){
                pan=new Pantalon();
                pan.setPantalon_id(rs.getInt("id_pan"));
                pan.setPantalon_descripcion(rs.getString("des_pan"));
                pan.setPantalon_imagen(rs.getString("url_pan"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            pan=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return pan;
    }
	/** Metodos GET de la clase producto
     * @return  */
	public int getPantalon_id(){
		 return this.id_pan;
	}
	public String getPantalon_descripcion(){
		 return this.des_pan;
	}
	public String getPantalon_imagen(){
		 return this.url_pan;
	}
	

	/** Metodos SET de la clase producto
     *  */

	public void setPantalon_id(int id_pan){
		 this.id_pan=id_pan;
	}
	public void setPantalon_descripcion(String des_pan){
		 this.des_pan=des_pan;
	}
	public void setPantalon_imagen(String url_pan){
		 this.url_pan=url_pan;
	}
	

}

