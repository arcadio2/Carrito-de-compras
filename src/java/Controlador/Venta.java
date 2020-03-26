package Controlador;

import java.sql.*;
import java.util.*;
/**
 * 
 * @autor 
 * Archivo: Venta.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Venta{

	private int venta_Codigo;
	private String venta_Fecha;
	private int usuario_Codigo;
	private double venta_TotalPagar;
        private int idpago;

    
	/** Crea un nueva instancia de la clase venta */
	public Venta(){

	}

    /**
     * Obtener el ultimo codigo que se genero de forma automatica
     * @return Retorna el codigo que se genero de la tabla Venta
     */
    private int ultimoCodigoInserto(Connection cn){
        int codigo=0;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            String sql="SELECT MAX(venta_Codigo) as Codigo FROM venta";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                codigo=rs.getInt("Codigo");
                break;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
            }catch(SQLException ex){

            }
        }
        return codigo;
    }

    public Vector<Venta> listaVentas(int idus){//Con magia de sirenas :D
        Vector<Venta> lv=new Vector<Venta>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM venta where usuario_Codigo=?";
            
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idus);
            rs=pr.executeQuery();
            while(rs.next()){
                Venta ven=new Venta();
                ven.setVenta_codigo(rs.getInt("venta_Codigo"));
                ven.setVenta_fecha(rs.getString("venta_Fecha"));
                ven.setVenta_totalpagar(rs.getInt("venta_TotalPagar"));
                ven.setUsuario_codigo(rs.getInt("usuario_Codigo"));
                ven.setIdpago(rs.getInt("idpago"));
                lv.add(ven);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lv=null;
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
        return lv;
    }
    
    public Vector<Venta> listaTVentas(){//Con magia de sirenas :D
        Vector<Venta> lv=new Vector<Venta>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM venta where idpago=2";
            
            pr=cn.prepareStatement(sql);
            
            rs=pr.executeQuery();
            while(rs.next()){
                Venta ven=new Venta();
                ven.setVenta_codigo(rs.getInt("venta_Codigo"));
                ven.setVenta_fecha(rs.getString("venta_Fecha"));
                ven.setVenta_totalpagar(rs.getInt("venta_TotalPagar"));
                ven.setUsuario_codigo(rs.getInt("usuario_Codigo"));
                ven.setIdpago(rs.getInt("idpago"));
                lv.add(ven);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lv=null;
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
        return lv;
    }
    
public boolean registrarVenta(Venta v, Vector<Detalleventa> ldv){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            String sql="INSERT INTO venta(venta_Fecha,usuario_Codigo,venta_TotalPagar,idpago) ";
            sql+=" VALUES(?,?,?,2)";
            pr=cn.prepareStatement(sql);
            pr.setString(1, v.getVenta_fecha());
            pr.setInt(2, v.getUsuario_codigo());
            pr.setDouble(3, v.getVenta_totalpagar());
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                int codigo=this.ultimoCodigoInserto(cn);
                registro=this.registrarDetalleVenta(codigo, ldv, cn);
            }else{
                registro=false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
    
public boolean eliminarVenta(int idVen){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            String sql="DELETE FROM venta WHERE venta_Codigo=?";
            pr=cn.prepareStatement(sql);
           
            pr.setInt(1, idVen);
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                
                registro=true;
                System.out.println("firulo eliminarven");
            }else{
                registro=false;
                System.out.println("no firulo eliminarven");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;System.out.println("no firulo eliminarcven");
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
    /**
     * Metodo utilizado para registrar el detalle de la venta
     * @param codigo Representa el codigo de la Venta
     * @param ldv Lista con los detalles de la Venta
     * @param cn Conexion con la base de datos
     */
    private boolean registrarDetalleVenta(int codigo, Vector<Detalleventa> ldv, Connection cn){
        boolean registro=false;
        PreparedStatement pr=null;
        try{
            for(Detalleventa dv : ldv){
                String sql="INSERT INTO detalleventa(venta_Codigo,det_item,det_codigo,det_cantidad,det_subtotal) VALUES(?,?,?,?,?)";
                pr=cn.prepareStatement(sql);
                pr.setInt(1, codigo);
                pr.setInt(2, dv.getDetventa_item());
                pr.setInt(3, dv.getProducto_codigo());
                pr.setInt(4, dv.getDetventa_cantidad());
                pr.setDouble(5, dv.getDetventa_subtotal());
                if(pr.executeUpdate()==1){
                    registro=true;
                }else{
                    registro=false;
                    break;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;
        }finally{
            try{
                pr.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
    
    public static boolean  ModificarPago(ID e){
        boolean test = false; 
        try{
            Connection con = ConexionUsuario.obtenerconexion();
            System.out.println(e.getUsuario());
                String q="update venta set idpago=1"
                    + " where venta_Codigo=?";
              PreparedStatement set=con.prepareStatement(q);
            set.setInt(1,e.getIdpago());
            int fin =set.executeUpdate();
                if (fin>0) {
                test=true; 
                    System.out.println("Ventaaaaaaa!");
                }else{
                test=false; 
                }
          
            con.close();
            
        }catch(Exception d){
            System.out.println("No se conecto a la tabla ");
            System.out.println(d.getStackTrace());
            System.out.println(d.getMessage());
        }
        
        
        return test;
    }
    
    

	/** Metodos GET de la clase venta */
	public int getVenta_codigo(){
		 return this.venta_Codigo;
	}
	public String getVenta_fecha(){
		 return this.venta_Fecha;
	}
	public int getUsuario_codigo(){
		 return this.usuario_Codigo;
	}
	public double getVenta_totalpagar(){
		 return this.venta_TotalPagar;
	}

	/** Metodos SET de la clase venta */

	public void setVenta_codigo(int venta_Codigo){
		 this.venta_Codigo=venta_Codigo;
	}
	public void setVenta_fecha(String venta_Fecha){
		 this.venta_Fecha=venta_Fecha;
	}
	public void setUsuario_codigo(int usuario_Codigo){
		 this.usuario_Codigo=usuario_Codigo;
	}
	public void setVenta_totalpagar(double venta_TotalPagar){
		 this.venta_TotalPagar=venta_TotalPagar;
	}
        public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }
}

