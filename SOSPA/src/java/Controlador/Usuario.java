package Controlador;

public class Usuario {
    private String username; 
    private String password; 
    private String correo;
    private int id_com; 
    private int id_tus;
    private int id; 
 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

  
    public int getId_com() {
        return id_com;
    }

 
    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

  
    public int getId_tus() {
        return id_tus;
    }

    public void setId_tus(int id_tus) {
        this.id_tus = id_tus;
    }

 
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    
    
    
}
