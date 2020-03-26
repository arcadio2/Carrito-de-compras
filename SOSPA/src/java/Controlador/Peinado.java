package Controlador;

import Controlador.Conexion;
import Controlador.Conexion;
import Controlador.Conexion;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;


public class Peinado{

	private int id_pei;
	private String url_pei;
	private int id_ros;
	

	/** Crea un nueva instancia de la clase producto */
	public Peinado(){

	}

   

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Peinado> listaPeinados(){//Con magia de sirenas :D
        Vector<Peinado> lp=new Vector<Peinado>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mpeinado";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Peinado pei=new Peinado();
                pei.setPeinado_id(rs.getInt("id_pei"));
                pei.setPeinado_imagen(rs.getString("url_pei"));
                pei.setPeinado_idRostro(rs.getInt("id_ros"));
               
                lp.add(pei);
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
     * @param idCamisa
     * @param codigoProducto Representa el codigo del producto que vamos a buscar
     * @return Retorna un producto buscado por el codigo
     */
   public Peinado buscarPeinado(int idPeinado){
        Peinado pei=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM mpeinado WHERE id_pei=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idPeinado);
            rs=pr.executeQuery();
            while(rs.next()){
                pei=new Peinado();
                pei.setPeinado_id(rs.getInt("id_pei"));
                pei.setPeinado_imagen(rs.getString("url_pei"));
                pei.setPeinado_idRostro(rs.getInt("id_ros"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            pei=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return pei;
    }


	/** Metodos GET de la clase producto
     * @return  */
	public int getPeinado_id(){
		 return this.id_pei;
	}
	public String getPeinado_imagen(){
		 return this.url_pei;
	}
        public int getPeinado_idRostro(){
		 return this.id_ros;
	}
	

	/** Metodos SET de la clase producto
     * @param camisa_Id */

	public void setPeinado_id(int id_pei){
		 this.id_pei=id_pei;
	}
	public void setPeinado_imagen(String url_pei){
		 this.url_pei=url_pei;
	}
        public void setPeinado_idRostro(int id_ros){
		 this.id_ros=id_ros;
	}
	

}

