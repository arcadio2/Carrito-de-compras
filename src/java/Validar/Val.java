/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import Controlador.ConexionUsuario;
import Controlador.EUsuario;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author arcad
 */
public class Val {
 
    public static boolean existeusuario(String usuario){
        boolean test = false; 
        List<EUsuario> lista= ConexionUsuario.getAllUsuarios(); 
         for(EUsuario a:lista){
               if (usuario.equals(a.getUsuario())) {
                   test = true; 
                   break; 
              }
          }
        
        return test; 
    }
    
    
    public static boolean contraseñacorrecta(String usuario, String Contraseña){
        boolean test = false; 
        //String ncon=Encriptar.sha1(Contraseña); 
         EUsuario obj= new EUsuario(usuario); 
           String contraseña = ConexionUsuario.getAllByUsername(obj).getContraseña();   
           if (Contraseña.equals(contraseña)) {
            test=true; 
            
        }else{
               test=false; 
           }
            return test; 
    }
    
       public static boolean validarnombre(String nomusu){
        boolean validarnomus=true; 
          String carc="|°¬;,.:-_}]`[^{+*~´¨¿¡'?=)(/&%$#<>";
          
            for (int i = 0; i < nomusu.length(); i++) {
                for (int j = 0; j < carc.length(); j++) {
                       if (nomusu.charAt(i)==carc.charAt(j)) {
                           validarnomus=false; 
                           break; 
                     }
                }
           }//fin del for de validar nombre de usuario
           if (nomusu.length()<4 || nomusu.length()>30) {
            validarnomus=false; 
           }

        return validarnomus; 
    }
    
    public static boolean validarcorreo(String correo){
        boolean valcorreo=true; 
        Pattern regexp=Pattern.compile(""
                + "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+"
                + "/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        Matcher compare=regexp.matcher(correo); 
        if (compare.matches()) {
             valcorreo=true; 
        }else{
            valcorreo=false; 
        }
        
        
        return valcorreo; 
    }
    
    
    public static boolean validarnullos(String usuario, String password, String correo){
        boolean valnulos=true; 
        
        if ("".equals(usuario) || "".equals(password) || "".equals(correo)) {
                 //no escribiste algo
                 valnulos=false; 

             }
        return valnulos; 
    }
    
    public static boolean validarcontra(String contra){
        boolean valcon=true; 
        if (contra.length()<8) {
            valcon =false; 
        }
        
        String invalidate="><"; 
        for (int i = 0; i < contra.length(); i++) {
            for (int j = 0; j < invalidate.length(); j++) {
                 if (contra.charAt(i)==invalidate.charAt(j)) {
                valcon=false; 
            }
            }
        }
        
        
        return valcon;
    }
    
    
    public static boolean validarnomtra(String nombre){
        boolean a=true; 
        if (nombre.length()<3) {
            a=false; 
        }
        if (nombre.length()>30) {
            a=false; 
        }
        String carc="|°¬;,.:-_}]`[^{+*~´¨¿¡'?=)(/&%$#<>";
          
            for (int i = 0; i < nombre.length(); i++) {
                for (int j = 0; j < carc.length(); j++) {
                       if (nombre.charAt(i)==carc.charAt(j)) {
                           a=false; 
                           break; 
                     }
                }
           }
        
        
        
        return a; 
    }
    
    public static boolean existecorreo(String email){
        boolean test= false; 
         List<EUsuario> lista= ConexionUsuario.getAllUsuarios(); 
         for(EUsuario a:lista){
               if (email.equals(a.getCorreo())) {
                   test = true; 
                   break; 
              }
          }
        
        
        return test; 
    }
    
    public static int obtenertus(String tus){
        int id_tus=0; 
        if (tus.equals("Cajero")) {
            id_tus=4; 
        }else if(tus.equals("Panadero")){
            id_tus=3;
        }
        return id_tus; 
    }
    
    
    
    
    
}
