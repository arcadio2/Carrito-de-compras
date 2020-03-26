package Controlador;

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
public class Producto{

   

	private int producto_Codigo;
	private String producto_Nombre;
	private double producto_Precio;
	private int producto_Stock;
        private int id_pro;
        private String url_pro;

   
	/** Crea un nueva instancia de la clase producto */
	public Producto(){

	}

    /**
     * Metodo utilizado para obtener todos los productos
     * @return Retorna una lista con todos los productos
     */
    public Vector<Producto> listaProductos(int idPro){//Con magia de sirenas :D
        Vector<Producto> lp=new Vector<Producto>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM subproducto where id_pro=?";
            
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idPro);
            rs=pr.executeQuery();
            while(rs.next()){
                Producto prod=new Producto();
                prod.setProducto_codigo(rs.getInt("id_sub"));
                prod.setProducto_nombre(rs.getString("nom_sub"));
                prod.setProducto_precio(rs.getDouble("pre_sub"));
                prod.setProducto_stock(rs.getInt("sto_sub"));
                prod.setUrl_pro(rs.getString("url_sub"));
                prod.setId_pro(rs.getInt("id_pro"));
                
                
                
                lp.add(prod);
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
    
    public Vector<Producto> listaTProductos(){//Con magia de sirenas :D
        Vector<Producto> lp=new Vector<Producto>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM subproducto";
            
            pr=cn.prepareStatement(sql);
            
            rs=pr.executeQuery();
            while(rs.next()){
                Producto prod=new Producto();
                prod.setProducto_codigo(rs.getInt("id_sub"));
                prod.setProducto_nombre(rs.getString("nom_sub"));
                prod.setProducto_precio(rs.getDouble("pre_sub"));
                prod.setProducto_stock(rs.getInt("sto_sub"));
                prod.setUrl_pro(rs.getString("url_sub"));
                prod.setId_pro(rs.getInt("id_pro"));
                
                
                lp.add(prod);
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
    public Producto buscarProducto(int codigoProducto){
        Producto prod=null;
        
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM subproducto WHERE id_sub=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, codigoProducto);
            rs=pr.executeQuery();
            while(rs.next()){
                prod=new Producto();
               prod.setProducto_codigo(rs.getInt("id_sub"));
                prod.setProducto_nombre(rs.getString("nom_sub"));
                prod.setProducto_precio(rs.getDouble("pre_sub"));
                prod.setProducto_stock(rs.getInt("sto_sub"));
                prod.setUrl_pro(rs.getString("url_sub"));
                prod.setId_pro(rs.getInt("id_pro"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            prod=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return prod;
    }
    
    
    
    /**
     * Metodo utilizado para actualizar el stock de los productos
     * @param vp Vector de productos que se va actualizar el stock
     * @return Retorna un valor booleano para saber si se actulizo los stocks
     */
    public boolean actualizarStocks(Vector<Producto> vp){
        boolean actualizo=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            for(Producto prod : vp){
                String sql="UPDATE subproducto SET ";
                sql+=" sto_sub=? ";
                sql+=" WHERE id_sub=?";
                pr=cn.prepareStatement(sql);
                pr.setInt(1, prod.getProducto_stock());
                pr.setInt(2, prod.getProducto_codigo());
                if(pr.executeUpdate()==1){
                    actualizo=true;
                }else{
                    actualizo=false;
                    break;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            actualizo=false;
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return actualizo;
    }
    
    public boolean actualizarStocksMas(int stock, int cod){
        boolean actualizo=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            
                String sql="UPDATE Producto SET ";
                sql+=" sto_sub=? ";
                sql+=" WHERE id_sub=?";
                pr=cn.prepareStatement(sql);
                pr.setInt(1, stock);
                pr.setInt(2,cod);
                if(pr.executeUpdate()==1){
                    actualizo=true;
                }else{
                    actualizo=false;
                    
                }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            actualizo=false;
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return actualizo;
    }
    
    
	/** Metodos GET de la clase producto */
	public int getProducto_codigo(){
		 return this.producto_Codigo;
	}
	public String getProducto_nombre(){
		 return this.producto_Nombre;
	}
	public double getProducto_precio(){
		 return this.producto_Precio;
	}
	public int getProducto_stock(){
		 return this.producto_Stock;
	}
         public String getUrl_pro() {
        return url_pro;
    }

    public void setUrl_pro(String url_pro) {
        this.url_pro = url_pro;
    }

	/** Metodos SET de la clase producto */

	public void setProducto_codigo(int producto_Codigo){
		 this.producto_Codigo=producto_Codigo;
	}
	public void setProducto_nombre(String producto_Nombre){
		 this.producto_Nombre=producto_Nombre;
	}
	public void setProducto_precio(double producto_Precio){
		 this.producto_Precio=producto_Precio;
	}
	public void setProducto_stock(int producto_Stock){
		 this.producto_Stock=producto_Stock;
	}
 /**
     * @return the id_pro
     */
    public int getId_pro() {
        return id_pro;
    }

    /**
     * @param id_pro the id_pro to set
     */
    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }
}

