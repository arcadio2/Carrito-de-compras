package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 
 * @autor 
 * Archivo: Detalleventa.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Detalleventa{
        private int detVenta_Codigo;
	private int venta_Codigo;
	private int detVenta_Item;
	private int producto_Codigo;
	private int detVenta_Cantidad;
	private double detVenta_SubTotal;

	/** Crea un nueva instancia de la clase detalleventa */
	public Detalleventa(){

	}
        public Vector<Detalleventa> listaDetalleVenta(int id){//Con magia de sirenas :D
        Vector<Detalleventa> ldv=new Vector<Detalleventa>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM detalleventa where venta_Codigo=?";
            
            pr=cn.prepareStatement(sql);
            pr.setInt(1, id);
            rs=pr.executeQuery();
            while(rs.next()){
                Detalleventa ven=new Detalleventa();
                ven.setDetVenta_Codigo(rs.getInt("id_ven"));
                ven.setVenta_codigo(rs.getInt("venta_Codigo"));
                ven.setDetventa_item(rs.getInt("det_item"));
                ven.setProducto_codigo(rs.getInt("det_codigo"));
                ven.setDetventa_cantidad(rs.getInt("det_cantidad"));
               ven.setDetventa_subtotal(rs.getDouble("det_subtotal"));
               
                ldv.add(ven);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            ldv=null;
            System.out.println("xdno");
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
                System.out.println("xd");
            }catch(SQLException ex){
                ex.printStackTrace();
                System.out.println("xdno");
            }
        }
        return ldv;
    }

	/** Metodos GET de la clase detalleventa */
	public int getVenta_codigo(){
		 return this.venta_Codigo;
	}
	public int getDetventa_item(){
		 return this.detVenta_Item;
	}
	public int getProducto_codigo(){
		 return this.producto_Codigo;
	}
	public int getDetventa_cantidad(){
		 return this.detVenta_Cantidad;
	}
	public double getDetventa_subtotal(){
		 return this.detVenta_SubTotal;
	}

	/** Metodos SET de la clase detalleventa */

	public void setVenta_codigo(int venta_Codigo){
		 this.venta_Codigo=venta_Codigo;
	}
	public void setDetventa_item(int detVenta_Item){
		 this.detVenta_Item=detVenta_Item;
	}
	public void setProducto_codigo(int producto_Codigo){
		 this.producto_Codigo=producto_Codigo;
	}
	public void setDetventa_cantidad(int detVenta_Cantidad){
		 this.detVenta_Cantidad=detVenta_Cantidad;
	}
	public void setDetventa_subtotal(double detVenta_SubTotal){
		 this.detVenta_SubTotal=detVenta_SubTotal;
	}

    public int getDetVenta_Codigo() {
        return detVenta_Codigo;
    }

    public void setDetVenta_Codigo(int detVenta_Codigo) {
        this.detVenta_Codigo = detVenta_Codigo;
    }

}

