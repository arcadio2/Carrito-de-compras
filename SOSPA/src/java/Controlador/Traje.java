package Controlador;

import java.sql.*;
import java.util.Vector;
import javax.servlet.http.HttpSession;

/**
 * 
 * @autor 
 * Archivo: Producto.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Traje{
        
	
	private int id_tra;
        private String nom_tra;
	private int id_cam;
	private int id_sac;
        private int id_cor;
        private int id_pan;
        private int id_zap;
      

	/** Crea un nueva instancia de la clase producto */
	public Traje(){

	}
        
        public Vector<Traje> listaTrajes(){//Con magia de sirenas :D
        Vector<Traje> lt=new Vector<Traje>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM dtraje";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Traje tra=new Traje();
                tra.setTraje_id(rs.getInt("id_tra"));
                tra.setTraje_nombre(rs.getString("nom_tra"));
                tra.setTrajeCamisa_id(rs.getInt("id_cam"));
                tra.setTrajeSaco_id(rs.getInt("id_sac"));
                tra.setTrajeCorbata_id(rs.getInt("id_cor"));
                tra.setTrajePantalon_id(rs.getInt("id_pan"));
                tra.setTrajeZapato_id(rs.getInt("id_zap"));
               
                lt.add(tra);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lt=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lt;
    }
        
      public Vector<Traje> listaTrajesUsuario(int idUs){//Con magia de sirenas :D
        Vector<Traje> ltu=new Vector<Traje>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT dtraje.nom_tra, dtraje.id_cam, dtraje.id_sac, dtraje.id_cor, dtraje.id_pan, dtraje.id_zap, dtraje.id_tra FROM dtraje INNER JOIN eguardarropa ON eguardarropa.id_tra = dtraje.id_tra WHERE eguardarropa.id_us = ?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idUs);
            rs=pr.executeQuery();
            while(rs.next()){
                Traje tra=new Traje();
                tra.setTraje_id(rs.getInt("id_tra"));
                tra.setTraje_nombre(rs.getString("nom_tra"));
                tra.setTrajeCamisa_id(rs.getInt("id_cam"));
                tra.setTrajeSaco_id(rs.getInt("id_sac"));
                tra.setTrajeCorbata_id(rs.getInt("id_cor"));
                tra.setTrajePantalon_id(rs.getInt("id_pan"));
                tra.setTrajeZapato_id(rs.getInt("id_zap"));
               
                ltu.add(tra);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            ltu=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return ltu;
    }  
        
        public Vector<Traje> listaTrajesCompartidos(){//Con magia de sirenas :D
        Vector<Traje> lt=new Vector<Traje>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT dtraje.id_tra, dtraje.nom_tra, dtraje.id_cam, dtraje.id_sac, dtraje.id_cor, dtraje.id_pan, dtraje.id_zap FROM eguardarropa INNER JOIN dtraje ON eguardarropa.id_tra = dtraje.id_tra WHERE eguardarropa.id_pos = 1";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Traje tra=new Traje();
                tra.setTraje_id(rs.getInt("id_tra"));
                tra.setTraje_nombre(rs.getString("nom_tra"));
                tra.setTrajeCamisa_id(rs.getInt("id_cam"));
                tra.setTrajeSaco_id(rs.getInt("id_sac"));
                tra.setTrajeCorbata_id(rs.getInt("id_cor"));
                tra.setTrajePantalon_id(rs.getInt("id_pan"));
                tra.setTrajeZapato_id(rs.getInt("id_zap"));
               
                lt.add(tra);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            lt=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return lt;
    }
                
         public Traje buscarTraje(int idCam,int idSac,int idCor,int idPan,String nomTra,int idZap){
        Traje tra=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT dtraje.id_tra FROM dtraje WHERE dtraje.id_cam = ? AND dtraje.id_sac = ? AND dtraje.id_cor = ? AND dtraje.id_pan = ? AND dtraje.nom_tra = ? AND dtraje.id_zap = ?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idCam);
            pr.setInt(2, idSac);
            pr.setInt(3, idCor);
            pr.setInt(4, idPan);
            pr.setString(5, nomTra);
            pr.setInt(6, idZap);
            rs=pr.executeQuery();
            while(rs.next()){
                tra = new Traje();
                tra.setTraje_id(rs.getInt("id_tra"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            tra=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return tra;
    }
        
        public Traje buscarTrajePorId(int idTra){
        Traje tra=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=Conexion.getConexion();
            String sql="SELECT * FROM dtraje WHERE dtraje.id_tra = ?";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idTra);
            rs=pr.executeQuery();
            while(rs.next()){
                tra = new Traje();
                tra.setTraje_id(rs.getInt("id_tra"));
                tra.setTraje_nombre(rs.getString("nom_tra"));
                tra.setTrajeCamisa_id(rs.getInt("id_cam"));
                tra.setTrajeSaco_id(rs.getInt("id_sac"));
                tra.setTrajeCorbata_id(rs.getInt("id_cor"));
                tra.setTrajePantalon_id(rs.getInt("id_pan"));
                tra.setTrajeZapato_id(rs.getInt("id_zap"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            tra=null;
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return tra;
    }
        
          public boolean registrarTraje(String nomTra,int idCam,int idSac,int idCor,int idPan, int idZap){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            String sql="INSERT INTO dtraje(nom_tra,id_cam,id_sac,id_cor,id_pan,id_zap) ";
            sql+=" VALUES(?,?,?,?,?,?)";
            pr=cn.prepareStatement(sql);
            pr.setString(1, nomTra);
            pr.setInt(2, idCam);
            pr.setInt(3, idSac);
            pr.setInt(4, idCor);
            pr.setInt(5, idPan);
            pr.setInt(6, idZap);
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                
                registro=true;
                System.out.println("si firulo regis");
            }else{
                registro=false;
                System.out.println("no firulo regis");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;
            System.out.println("no firulo regis");
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
      
         
         public boolean registrarTrajeGuardarropa(int idUs,int idTra){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            String sql="INSERT INTO `paula`.`eguardarropa`(`id_us`, `id_tra`,`id_fav`,`id_pos`) VALUES (?, ?,2,2)";
            pr=cn.prepareStatement(sql);
            pr.setInt(1, idUs);
            pr.setInt(2, idTra);
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                
                registro=true;
                System.out.println("firulo guardarr");
            }else{
                registro=false;
                System.out.println("no firulo guardarropa");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;System.out.println("no firulo guardarropa");
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }
         
         
         
	
	public int getTraje_id(){
		 return this.id_tra;
	}
        public String getTraje_nombre(){
                return this.nom_tra;
        }
	public int getTrajeCamisa_id(){
		 return this.id_cam;
	}
        public int getTrajeSaco_id(){
		 return this.id_sac;
	}
        public int getTrajeCorbata_id(){
		 return this.id_cor;
	}
        public int getTrajePantalon_id(){
		 return this.id_pan;
	}
         public int getTrajeZapato_id(){
		 return this.id_zap;
	}
	

	/** Metodos SET de la clase producto
     * @param id_tra */

	
         public void setTraje_id(int id_tra){
		 this.id_tra=id_tra;
	}
         public void setTraje_nombre(String nom_tra){
		 this.nom_tra=nom_tra;
	}
        public void setTrajeCamisa_id(int id_cam){
		 this.id_cam=id_cam;
	}
        public void setTrajeSaco_id(int id_sac){
		 this.id_sac=id_sac;
	}
        public void setTrajeCorbata_id(int id_cor){
		 this.id_cor=id_cor;
	}
        public void setTrajePantalon_id(int id_pan){
		 this.id_pan=id_pan;
	}
        public void setTrajeZapato_id(int id_zap){
		 this.id_zap=id_zap;
	}
	

}


