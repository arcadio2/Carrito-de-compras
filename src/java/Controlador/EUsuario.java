
package Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EUsuario {
private String usuario; 
private String correo; 
private String contraseña; 
private String ultimasesion; 
private int id; 
private int id_tus; 

    public EUsuario(String usuario, String correo, String contraseña) {
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        ///this.ultimasesion = ultimasesion;
        Date obj= new Date(); 
        SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd hh:mm:ss"); 
        this.ultimasesion=sdf.format(obj); 
    }
        public EUsuario(String usuario, String correo, String contraseña, int id_tus) {
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        ///this.ultimasesion = ultimasesion;
        Date obj= new Date(); 
        SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd hh:mm:ss"); 
        this.ultimasesion=sdf.format(obj); 
        this.id_tus=id_tus; 
    }

    public EUsuario() {
      
    }
    
    public EUsuario(String Usuario){
        this.usuario = Usuario; 
    }
    
    public EUsuario(String Usuario, String Contraseña, int Id){
        this.usuario=Usuario; 
        this.contraseña=Contraseña;
        this.id=Id;
    }
    public EUsuario(int id){
        this.id=id; 
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getContraseña() {
        return contraseña;
    }


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the ultimasesion
     */
    public String getUltimasesion() {
        return ultimasesion;
    }

    /**
     * @param ultimasesion the ultimasesion to set
     */
    public void setUltimasesion(String ultimasesion) {
        this.ultimasesion = ultimasesion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_tus
     */
    public int getId_tus() {
        return id_tus;
    }

    /**
     * @param id_tus the id_tus to set
     */
    public void setId_tus(int id_tus) {
        this.id_tus = id_tus;
    }






    
}
