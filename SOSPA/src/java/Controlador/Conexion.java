/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.sql.*;
/**
 *
 * @author jaime
 */
public class Conexion {

    public static Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://132.148.26.107:3306/paula";
            String usuario="paula";
            String clave="n0m3l0";
            return DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
       
    }

}
