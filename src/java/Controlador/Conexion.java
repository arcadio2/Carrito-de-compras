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
            String url="jdbc:mysql://localhost:3306/carrito";
            String usuario="root";
            String clave="n0m3l0";
            return DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("no conecto");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("no conecto");
        }
        return null;
    }

}
