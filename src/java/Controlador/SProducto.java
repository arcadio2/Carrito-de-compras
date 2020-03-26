package Controlador;

import Controlador.Conexion;
import java.sql.*;
import java.util.Vector;

/**
 * 
 * @autor 
 * Archivo: Producto.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class SProducto{

	private int id_producto;
	private String nom_pro;
	
	/** Crea un nueva instancia de la clase producto */
	public SProducto(){

	}

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<SProducto> listaSProductos(){//Con magia de sirenas :D
        Vector<SProducto> lsp=new Vector<SProducto>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM producto";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                SProducto sprod=new SProducto();
                sprod.setProducto_codigo(rs.getInt("id_pro"));
                sprod.setProducto_nombre(rs.getString("cla_pro"));
                
                lsp.add(sprod);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lsp=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lsp;
    }

    public int contarProducto(int codigoProducto) throws SQLException{
        
     
            
            
        int n= 0;
         PreparedStatement pr=null;
     Connection  dbConnection = Conexion.getConexion();
     Statement stm = dbConnection.createStatement();
     String sql="SELECT count(id_sub) as producto FROM subproducto where id_pro=?";
     // almaceno resultado de consulta en ResultSet
     pr=dbConnection.prepareStatement(sql);
            pr.setInt(1, codigoProducto);
            
     ResultSet  rs=pr.executeQuery();;
     // chequeo que el result set no sea vacío, moviendo el cursor a la 
     // primer fila. (El cursor inicia antes de la primer fila)
        
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        n= rs.getInt(1);
     }
     // libero recursos
     stm.close();
     dbConnection.close();
     return n;
    }
    
   public SProducto buscarSProducto(int idProducto){
        SProducto spro=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM producto WHERE id_pro=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idProducto);
            rs=pr.executeQuery();
            while(rs.next()){
                spro=new SProducto();
                spro.setProducto_codigo(rs.getInt("id_pro"));
                spro.setProducto_nombre(rs.getString("cla_pro"));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            spro=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return spro;
    }

	/** Metodos GET de la clase producto
     * @return  */
	public int getProducto_codigo(){
		 return this.id_producto;
	}
	public String getProducto_nombre(){
		 return this.nom_pro;
	}
	
	/** Metodos SET de la clase producto
     * @param id_producto */

	public void setProducto_codigo(int id_producto){
		 this.id_producto=id_producto;
	}
	public void setProducto_nombre(String nom_pro){
		 this.nom_pro=nom_pro;
	}
	

}

