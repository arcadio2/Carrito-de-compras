package Controlador;

import java.sql.*;

/**
 * 
 * @autor 
 * Archivo: Producto.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Guardarropa{

	private int id_gua;
	
        private int id_us;
	private int id_tra;
        private int id_fav;
        private int id_pos;
	/** Crea un nueva instancia de la clase producto */
	public Guardarropa(){

	}
        
        public Guardarropa buscarGuardarropa(int idTra){
        Guardarropa gua=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM eguardarropa WHERE id_tra=?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idTra);
            rs=pr.executeQuery();
            while(rs.next()){
                gua=new Guardarropa();
                gua.setGuardarropa_id(rs.getInt("id_gua"));
                gua.setUsuario_id(rs.getInt("id_us"));
                gua.setTraje_id(rs.getInt("id_tra"));
                gua.setFavorito_id(rs.getInt("id_fav"));
                gua.setCompartir_id(rs.getInt("id_pos"));
                
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            gua=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return gua;
    }
        public boolean añadirFavorito(int idFav, int idGua){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        if(idFav==2){
            idFav=1;
        }else{
            idFav=2;
        }
        
        try{
            cn=Conexion.getConexion();
            String sql="UPDATE `paula`.`eguardarropa` SET `id_fav` = ? WHERE `id_gua` = ?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idFav);
            pr.setInt(2, idGua);
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                
                registro=true;
                System.out.println("firulo fav");
            }else{
                registro=false;
                System.out.println("no firulo fav");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;System.out.println("no firulo fav");
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
        
        public boolean Compartir(int idCom, int idGua){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        if(idCom==2){
            idCom=1;
        }else{
            idCom=2;
        }
        
        try{
            cn=Conexion.getConexion();
            String sql="UPDATE `paula`.`eguardarropa` SET `id_pos` = ? WHERE `id_gua` = ?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idCom);
            pr.setInt(2, idGua);
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                
                registro=true;
                System.out.println("firulo comp");
            }else{
                registro=false;
                System.out.println("no firulo comp");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;System.out.println("no firulo comp");
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
        

	public int getGuardarropa_id(){
		 return this.id_gua;
	}
	public int getTraje_id(){
		 return this.id_tra;
	}
        public int getUsuario_id(){
		 return this.id_us;
	}
	public int getFavorito_id(){
		 return this.id_fav;
	}
        public int getCompartir_id(){
		 return this.id_pos;
	}

	/** Metodos SET de la clase producto */

	public void setGuardarropa_id(int id_gua){
		 this.id_gua=id_gua;
	}
	public void setTraje_id(int id_tra){
		 this.id_tra=id_tra;
	}
        public void setUsuario_id(int id_us){
		 this.id_us=id_us;
	}
        public void setFavorito_id(int id_fav){
		 this.id_fav=id_fav;
	}
        public void setCompartir_id(int id_pos){
		 this.id_pos=id_pos;
	}
	

}

